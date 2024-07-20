package ru.itis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.itis.dto.MessageDto;
import ru.itis.service.KafkaProducer;
import ru.itis.service.MessageService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class KafkaController {
    private final KafkaProducer producer;

    private final MessageService messageService;

    private final CacheManager cacheManager;

    @Cacheable(value = "Message", key = "#id")
    @GetMapping("/{id}")
    public MessageDto getMessage(@PathVariable("id") Long id) {
        return messageService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public MessageDto saveMessage(@RequestBody MessageDto message) {
        producer.sendMessage(message.getText());
        return messageService.saveMessage(message);
    }
}
