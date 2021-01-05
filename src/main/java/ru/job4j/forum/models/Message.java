package ru.job4j.forum.models;

import java.util.Date;

public class Message {

    private User author;
    private Date created;
    private String text;

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
}
