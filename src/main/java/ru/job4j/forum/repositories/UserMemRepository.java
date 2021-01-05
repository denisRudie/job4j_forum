package ru.job4j.forum.repositories;

import org.springframework.stereotype.Repository;
import ru.job4j.forum.models.Authority;
import ru.job4j.forum.models.User;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserMemRepository {

    private final Map<String, User> users = new HashMap<>();

    {
        users.put("admin", User.of(1, "admin", "1", new Authority("ADMIN")));
        users.put("user", User.of(2, "user", "1", new Authority("USER")));
    }

    public User getUserByName(String name) {
        return users.get(name);
    }
}
