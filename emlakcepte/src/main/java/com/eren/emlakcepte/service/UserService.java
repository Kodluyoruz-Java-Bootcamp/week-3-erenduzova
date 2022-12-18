package com.eren.emlakcepte.service;


import com.eren.emlakcepte.model.Realty;
import com.eren.emlakcepte.model.User;
import com.eren.emlakcepte.model.enums.RealtyStatus;
import com.eren.emlakcepte.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Create User
    public void createUser(User user) {
        // Stop Duplicate Users
        if (userRepository.getAllUsers().stream().anyMatch(user1 -> user1.getMail().equals(user.getMail()))) {
            System.out.println("Existing user");
            return;
        }
        if (user.getPassword().length() < 5) {
            System.out.println("Şifre en az 5 karakterli olmalı");
        } else {
            userRepository.createUser(user);
        }
    }

    public List<User> getAllUser() {
        return userRepository.getAllUsers();
    }

    public User getUser(User searchedUser) {
        return userRepository.getAllUsers().stream().filter(user -> user.equals(searchedUser)).findFirst().orElse(null);
    }

    public User getUserByMail(String email) {
        return userRepository.getByMail(email);
    }
/*
    public void printAllUser() {
        getAllUser().forEach(user -> System.out.println(user.getName()));
    }
*/
    // Update password
    public User updatePassword(String email, String newPassword) {
        User user = getUserByMail(email);
        userRepository.getAllUsers().stream()
                .filter(user1 -> user1.equals(user))
                .findFirst().ifPresent(passwordUpdateUser -> passwordUpdateUser.setPassword(newPassword));
        return user;
    }
/*
    public void printUser(User searchedUser) {
        if (getUser(searchedUser) == null) {
            System.out.println("Not a user");
        } else {
            System.out.println(getUser(searchedUser));
        }
    }
*/
    public boolean hasMaxRealty(User searchedUser) {
        return (getUser(searchedUser).getRealtyList().size() >= 3);
    }


}
