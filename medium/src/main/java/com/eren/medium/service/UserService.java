package com.eren.medium.service;


import com.eren.medium.repository.UserRepository;
import com.eren.medium.model.Blog;
import com.eren.medium.model.User;
import com.eren.medium.model.enums.BlogStatus;
import com.eren.medium.model.enums.BlogTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ArrayList<User> getAllUsers() {
        return userRepository.findAllUsers();
    }

    public User getByMail(String email) {
        return getAllUsers().stream().filter(user -> user.getEmail().equals(email)).findFirst().orElse(null);
    }

    // Create user
    public void createUser(User user) {
        if (!(getAllUsers().contains(user))) {
            userRepository.createUser(user);
        } else {
            System.out.println("User already exists");
        }
    }

    // Follow user
    public void follow(String fMail, String uMail) {
        User follower = getByMail(fMail);
        User user = getByMail(uMail);
        if (!(user.getFollowers().contains(follower))) {
            userRepository.followUser(follower, user);
        } else {
            System.out.println(follower.getName() + " is already a follower of " + user.getName());
        }
    }

    public List<Blog> getAllBlogs(String email) {
        User user = getByMail(email);
        return userRepository.getAllBlogs(user);
    }

    public List<Blog> getAllDrafts(String email) {
        User user = getByMail(email);
        return userRepository.getAllDrafts(user);
    }

    public void addDraft(Blog draft) {
        userRepository.addDraftToUser(draft);
    }

    public void followTag(String email, BlogTag tag) {
        User user = getByMail(email);
        userRepository.followBlogTag(user, tag);
    }


}
