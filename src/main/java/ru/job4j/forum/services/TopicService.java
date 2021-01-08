package ru.job4j.forum.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.job4j.forum.models.Message;
import ru.job4j.forum.models.Topic;
import ru.job4j.forum.models.User;
import ru.job4j.forum.repositories.jpa.AuthorityRepository;
import ru.job4j.forum.repositories.jpa.MessageRepository;
import ru.job4j.forum.repositories.jpa.TopicRepository;
import ru.job4j.forum.repositories.jpa.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {

    private final PasswordEncoder encoder;
    private final TopicRepository topicRepository;
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    @Autowired
    public TopicService(PasswordEncoder encoder,
                        TopicRepository topicRepository,
                        MessageRepository messageRepository,
                        UserRepository userRepository,
                        AuthorityRepository authorityRepository) {
        this.encoder = encoder;
        this.topicRepository = topicRepository;
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }

    public List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Topic getTopicById(int id) {
        return topicRepository.findById(id).get();
    }

    public Topic saveTopic(Topic topic, String username, Message msg) {
        if (topic.getId() != 0) {
            Topic t = getTopicById(topic.getId());
            t.setName(topic.getName());
            t.setDescription(topic.getDescription());
            return topicRepository.save(t);
        } else {
            User u = getUserByName(username);
            topic.setAuthor(u);
            Topic t = topicRepository.save(topic);
            msg.setAuthor(u);
            msg.setTopic(t);
            messageRepository.save(msg);
            return t;
        }
    }

    public Message addMessage(Message msg, int topicId, String username) {
        User u = getUserByName(username);
        msg.setAuthor(u);
        Topic t = getTopicById(topicId);
        msg.setTopic(t);
        return messageRepository.save(msg);
    }

    public User getUserByName(String name) {
        return userRepository.findUserByUsername(name);
    }

    public void register(User user) {
        user.setEnabled(true);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setAuthority(authorityRepository.findByAuthority("ROLE_USER"));
        userRepository.save(user);
    }
}
