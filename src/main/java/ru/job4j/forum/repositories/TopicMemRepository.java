package ru.job4j.forum.repositories;

import ru.job4j.forum.models.Message;
import ru.job4j.forum.models.Topic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Repository
public class TopicMemRepository {
    private static int TOPIC_ID = 0;
    private final Map<Integer, Topic> topics = new HashMap<>();

    public List<Topic> getAll() {
        return new ArrayList<>(topics.values());
    }

    public Topic getById(int id) {
        return topics.get(id);
    }

    public void addTopic(Topic topic) {
        topic.setId(++TOPIC_ID);
        topics.put(TOPIC_ID, topic);
    }

    public void updateTopic(Topic topic) {
        Topic current = topics.get(topic.getId());
        current.setName(topic.getName());
        current.setDescription(topic.getDescription());
    }

    public void addMsgByTopicId(int topicId, Message msg) {
        topics.get(topicId).addMsg(msg);
    }
}
