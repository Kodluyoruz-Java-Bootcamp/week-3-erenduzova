package com.eren.medium.controller;

import com.eren.medium.model.Blog;
import com.eren.medium.model.enums.BlogTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import com.eren.medium.model.User;
import com.eren.medium.service.UserService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Get All Users
    @GetMapping
    public List<User> getAll() {
        return userService.getAllUsers();
    }

    // Get a User
    @GetMapping(value = "/{email}")
    public User getByMail(@PathVariable String email) {
        return userService.getByMail(email);
    }

    // Create User
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        userService.createUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    // Follow Other Users
    @PostMapping(value = "/followUser")
    public ResponseEntity<String> follow(@RequestBody Map<String,String> mails) {
        userService.follow(mails.get("fMail"), mails.get("uMail"));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Follow tags
    @PostMapping(value = "{email}/follow/{tag}")
    public void followTag(@PathVariable String email, @PathVariable BlogTag tag) {
        userService.followTag(email, tag);
    }

    // Get User's Drafts
    @GetMapping(value = "/{email}/drafts")
    public ResponseEntity<List<Blog>> getDrafts(@PathVariable String email) {
        List<Blog> draftList = userService.getAllDrafts(email);
        return new ResponseEntity<>(draftList, HttpStatus.OK);
    }

    // Get User's Published Blogs
    @GetMapping(value = "/{email}/blogs")
    public void getPublishedBlogs(@PathVariable String email) {
        userService.getAllBlogs(email);
    }


}
