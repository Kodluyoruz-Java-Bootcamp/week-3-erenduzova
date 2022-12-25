package com.eren.medium.service;


import com.eren.medium.model.User;
import com.eren.medium.repository.BlogRepository;
import com.eren.medium.model.Blog;
import com.eren.medium.model.enums.BlogStatus;
import com.eren.medium.model.enums.BlogTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService {

    @Autowired
    BlogRepository blogRepository;
    @Autowired
    UserService userService;

    public List<Blog> getAllBlogs() {
        return blogRepository.getAllBlogs();
    }

    public void createDraft(Blog draft, String email) {
        draft.setUser(userService.getByMail(email));
        if (!(getAllBlogs().contains(draft))) {
            blogRepository.addBlog(draft);
        } else {
            System.out.println("Duplicate Blog!!!");
        }
    }

    public void publish(Long draft_id) {
        Blog draft = getBlogById(draft_id);
        if (draft.getStatus().equals(BlogStatus.DRAFT)) {
            blogRepository.publishDraft(draft);
        } else {
            System.out.println("Already published!!!");
        }
    }

    public List<Blog> getTagsBlogs(BlogTag tag) {
        return getAllBlogs().stream().
                filter(blog -> blog.getTag().equals(tag)).collect(Collectors.toList());
    }

    public Blog getBlogById(long l) {
        return getAllBlogs().stream().filter(blog -> blog.getId().equals(l)).findFirst().orElse(null);
    }

    public void deleteBlog(long l) {
        if (getBlogById(l) != null) {
            blogRepository.removeBlog(getBlogById(l));
        } else {
            System.out.println("There is no blog with this id");
        }
    }

    public List<Blog> getAllPublishedBlogs() {
        return getAllBlogs().stream().filter(blog -> blog.getStatus().equals(BlogStatus.PUBLISHED)).collect(Collectors.toList());
    }
}
