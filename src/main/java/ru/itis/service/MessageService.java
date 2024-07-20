package ru.itis.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.dto.MessageDto;
import ru.itis.repositories.MessageRepository;
import ru.itis.utils.Message;


@Service
@AllArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageDto findById(Long id) {
        return messageRepository.findById(id)
                .map(MessageDto::from)
                .orElseThrow(() -> new EntityNotFoundException("Message not found with id " + id));
    }

    public MessageDto saveMessage(MessageDto message) {
        Message newMessage = Message.builder()
                .text(message.getText())
                .build();
        messageRepository.save(newMessage);
        return MessageDto.from(newMessage);
    }

    public Message updateMessage(Message message) {
        findById(message.getId());
        return messageRepository.save(message);
    }
}
