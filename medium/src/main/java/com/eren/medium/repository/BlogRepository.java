package com.eren.medium.repository;

import com.eren.medium.model.Blog;
import com.eren.medium.model.enums.BlogStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BlogRepository {

    private static List<Blog> blogs = new ArrayList<>();

    public List<Blog> getAllBlogs() {
        return blogs;
    }

    public void addBlog(Blog blog) {
        getAllBlogs().add(blog);
    }

    public void publishDraft(Blog draft) {
        draft.setStatus(BlogStatus.PUBLISHED);
    }

    public void removeBlog(Blog blog) {
        blog.setStatus(BlogStatus.DELETED);
    }
}
