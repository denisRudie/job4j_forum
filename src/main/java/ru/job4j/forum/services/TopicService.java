package ru.job4j.forum.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.forum.models.Message;
import ru.job4j.forum.models.Topic;
import ru.job4j.forum.models.User;
import ru.job4j.forum.repositories.TopicMemRepository;
import ru.job4j.forum.repositories.UserMemRepository;

import java.util.List;

@Service
public class TopicService {

    private final TopicMemRepository topicRepository;
    private final UserMemRepository userRepository;

    @Autowired
    public TopicService(TopicMemRepository topicRepository, UserMemRepository userRepository) {
        this.topicRepository = topicRepository;
        this.userRepository = userRepository;
    }

    public List<Topic> getAllTopics() {
        return topicRepository.getAll();
    }

    public Topic getTopicById(int id) {
        return topicRepository.getById(id);
    }

    public void updateTopic(Topic topic) {
        if (topic.getId() != 0) {
            topicRepository.updateTopic(topic);
        } else {
            topicRepository.addTopic(topic);
        }
    }

    public void addMessage(int topicId, Message msg) {
        topicRepository.addMsgByTopicId(topicId, msg);
    }
}
