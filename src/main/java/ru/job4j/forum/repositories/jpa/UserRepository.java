package ru.job4j.forum.repositories.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.forum.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User findUserByUsername(String username);
}
