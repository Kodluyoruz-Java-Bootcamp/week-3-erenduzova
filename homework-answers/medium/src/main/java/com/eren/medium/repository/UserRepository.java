package com.eren.medium.repository;

import com.eren.medium.model.Blog;
import com.eren.medium.model.User;
import com.eren.medium.model.enums.BlogStatus;
import com.eren.medium.model.enums.BlogTag;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserRepository {

    private static ArrayList<User> users = new ArrayList<>();

    public void createUser(User user) {
        users.add(user);
    }

    public ArrayList<User> findAllUsers() {
        return users;
    }

    public void followUser(User follower, User user) {
        user.getFollowers().add(follower);
    }

    public List<Blog> getAllBlogs(User user) {
        return user.getBlogs().stream().filter(blog -> !blog.getStatus().equals(BlogStatus.PUBLISHED)).collect(Collectors.toList());
    }

    public List<Blog> getAllDrafts(User user) {
        return user.getBlogs().stream().filter(blog -> blog.getStatus().equals(BlogStatus.DRAFT)).collect(Collectors.toList());
    }


    public void addDraftToUser(Blog draft) {
        User writer = draft.getUser();
        writer.getBlogs().add(draft);
    }

    public void followBlogTag(User user, BlogTag tag) {
        user.getFollowedTags().add(tag);
    }
}
