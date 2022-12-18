package com.eren.emlakcepte.repository;

import com.eren.emlakcepte.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {

    private static List<User> userList = new ArrayList<>();

    public void createUser(User user) {
        userList.add(user);
    }

    public List<User> getAllUsers() {
        return userList;
    }

    public User getByMail(String email) {
        return userList.stream().filter(user -> user.getMail().equals(email)).findFirst().get();
    }


}
