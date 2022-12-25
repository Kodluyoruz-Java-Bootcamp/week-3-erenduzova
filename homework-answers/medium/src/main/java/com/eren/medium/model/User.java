package com.eren.medium.model;


import com.eren.medium.model.enums.BlogStatus;
import com.eren.medium.model.enums.BlogTag;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.ArrayList;
import java.util.List;
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "email"
)
public class User {

    private String name;
    private String email;
    private String password;
    private List<Blog> blogs = new ArrayList<>();
    private List<User> followers = new ArrayList<>();
    private List<BlogTag> followedTags = new ArrayList<>();

    public User() {
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public List<BlogTag> getFollowedTags() {
        return followedTags;
    }

    public void setFollowedTags(List<BlogTag> followedTags) {
        this.followedTags = followedTags;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", mail='" + email + '\'' +
                ", password='" + password + '\'' +
                ", blogs=" + blogs.stream().filter(blog -> !blog.getStatus().equals(BlogStatus.DELETED))
                                    .map(Blog::getId).toList() +
                ", followers=" + followers.stream().map(User::getName).toList() +
                ", followedTags=" + followedTags +
                '}';
    }
}
