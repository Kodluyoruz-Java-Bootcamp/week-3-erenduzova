package com.eren.emlakcepte.repository;

import com.eren.emlakcepte.model.Message;
import com.eren.emlakcepte.model.enums.MessageStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MessageRepository {

    private static List<Message> messages = new ArrayList<>();

    // Get All Messages
    public List<Message> getAll() {
        return messages.stream()
                .filter(message -> message.getStatus().equals(MessageStatus.SAVED))
                .collect(Collectors.toList());
    }

    // Add Message
    public void add(Message message) {
        messages.add(message);
    }

}
