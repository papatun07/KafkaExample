package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.utils.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {}
