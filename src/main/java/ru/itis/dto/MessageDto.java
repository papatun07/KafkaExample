package ru.itis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.utils.Message;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto implements Serializable {
    private Long id;

    private String text;

    public static MessageDto from(Message message) {
        return MessageDto.builder()
                .id(message.getId())
                .text(message.getText())
                .build();
    }

    public static List<MessageDto> from(List<Message> messages) {
        return messages.stream().map(MessageDto::from).collect(Collectors.toList());
    }
}
