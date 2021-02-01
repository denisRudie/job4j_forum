package ru.job4j.forum.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
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
}
