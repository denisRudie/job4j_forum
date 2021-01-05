package ru.job4j.forum.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Topic {

    private int id;
    private String name;
    private String description;
    private Date created;
    private User author;
    private List<Message> messages = new ArrayList<>();

    public Topic() {
        created = new Date();
    }

    public static Topic of(String name, String desc) {
        Topic topic = new Topic();
        topic.name = name;
        topic.description = desc;
        return topic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public void addMsg(Message msg) {
        messages.add(msg);
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topic topic = (Topic) o;
        return id == topic.id &&
                Objects.equals(name, topic.name) &&
                Objects.equals(description, topic.description) &&
                Objects.equals(created, topic.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, created);
    }
}
