package com.eren.emlakcepte.model;

import com.eren.emlakcepte.model.enums.MessageStatus;

public class Message {

    private Long id;
    private String title;
    private String content;
    private User from;
    private User to;
    private MessageStatus status = MessageStatus.SAVED;

    public Message() {
    }

    public Message(Long id, String title, String content) {
        super();
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public User getTo() {
        return to;
    }

    public void setTo(User to) {
        this.to = to;
    }

    public MessageStatus getStatus() {
        return status;
    }

    public void setStatus(MessageStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Message{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", from=" + from.getMail() +
                ", to=" + to.getMail() +
                '}';
    }
}
