package ru.job4j.forum.models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "topics")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private Date created;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;
    @OneToMany(mappedBy = "topic")
    private List<Message> messages = new ArrayList<>();

    public Topic() {
        created = new Date();
    }

    public void addMsg(Message msg) {
        messages.add(msg);
    }
}
