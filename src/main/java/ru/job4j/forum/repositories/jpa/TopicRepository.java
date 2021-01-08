package ru.job4j.forum.repositories.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.forum.models.Topic;

@Repository
public interface TopicRepository extends CrudRepository<Topic, Integer> {
}
