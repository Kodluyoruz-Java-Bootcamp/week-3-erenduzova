package com.eren.emlakcepte.service;

import com.eren.emlakcepte.model.Message;
import com.eren.emlakcepte.model.User;
import com.eren.emlakcepte.model.enums.MessageStatus;
import com.eren.emlakcepte.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UserService userService;

    private List<Message> getAll() {
        return messageRepository.getAll();
    }

    // Get Message By Id
    public Message getById(Long mesId) {
        return getAll().stream()
                .filter(message -> message.getId().equals(mesId)).findFirst().get();
    }

    // Get User's Messages ( Inbox )
    public List<Message> getInboxByEmail(String email) {
        User user = userService.getUserByMail(email);
        return getAll().stream()
                .filter(message -> message.getTo().equals(user))
                .collect(Collectors.toList());
    }

    // Get User's Messages ( Sent )
    public List<Message> getSentByEmail(String email) {
        User user = userService.getUserByMail(email);
        return getAll().stream()
                .filter(message -> message.getFrom().equals(user))
                .collect(Collectors.toList());
    }

    // Create Message
    public Message create(String fromMail, String toMail, Message message) {
        User from = userService.getUserByMail(fromMail);
        User to = userService.getUserByMail(toMail);
        message.setFrom(from);
        message.setTo(to);
        messageRepository.add(message);
        return message;
    }

    // Delete Message
    public void deleteMessage(long mesId) {
        getById(mesId).setStatus(MessageStatus.DELETED);
    }


}
