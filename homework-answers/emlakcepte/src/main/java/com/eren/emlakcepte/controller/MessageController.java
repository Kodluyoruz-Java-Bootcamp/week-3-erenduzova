package com.eren.emlakcepte.controller;

import com.eren.emlakcepte.model.Message;
import com.eren.emlakcepte.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    // Get Inbox of a user
    @GetMapping(value = "/{email}/inbox")
    public List<Message> getUserInbox(@PathVariable String email) {
        return messageService.getInboxByEmail(email);
    }

    // Get Sent Box of a user
    @GetMapping(value = "/{email}/sent")
    public List<Message> getUserSent(@PathVariable String email) {
        return messageService.getSentByEmail(email);
    }

    // Create Message
    @PostMapping(value = "/{fromMail}/{toMail}")
    public Message create(@PathVariable String fromMail,
                          @PathVariable String toMail,
                          @RequestBody Message message) {
        return messageService.create(fromMail, toMail, message);
    }

    // Delete Message
    @PostMapping(value = "/{mesId}")
    public void delete(@PathVariable long mes_id) {
        messageService.deleteMessage(mes_id);
    }




}
