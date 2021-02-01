package ru.job4j.forum.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Authority authority;
    private boolean enabled;

    public static User of(int id, String username, String pwd, Authority authority) {
        User user = new User();
        user.id = id;
        user.username = username;
        user.password = pwd;
        user.authority = authority;
        return user;
    }
}
