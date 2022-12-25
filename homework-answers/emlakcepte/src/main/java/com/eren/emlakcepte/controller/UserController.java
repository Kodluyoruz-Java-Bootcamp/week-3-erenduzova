package com.eren.emlakcepte.controller;

import com.eren.emlakcepte.model.Realty;
import com.eren.emlakcepte.model.User;
import com.eren.emlakcepte.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return userService.getAllUser();
    }

    // Get User By Email
    @GetMapping(value = "/{email}")
    public User getByMail(@PathVariable String email) {
        return userService.getUserByMail(email);
    }

    // Create User
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        userService.createUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    // Update Password
    @PostMapping(value = "/{email}/update")
    public User updatePassword(@PathVariable String email, @RequestBody Map<String,String> body) {
        return userService.updatePassword(email, body.get("newPassword"));
    }


}
