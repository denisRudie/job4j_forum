package ru.job4j.forum.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;
    private Date created;
    private String text;
    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    public Message() {
        created = new Date();
    }

    public static Message of(User author, String text) {
        Message message = new Message();
        message.author = author;
        message.created = new Date();
        message.text = text;
        return message;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
