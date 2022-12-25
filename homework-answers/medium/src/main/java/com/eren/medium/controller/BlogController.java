package com.eren.medium.controller;

import com.eren.medium.model.Blog;
import com.eren.medium.service.BlogService;
import com.eren.medium.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private UserService userService;

    // Get All Published Drafts (Blogs)
    @GetMapping
    public List<Blog> getAll() {
        return blogService.getAllPublishedBlogs();
    }

    // Create Draft
    @PostMapping(value = "/draft/{email}")
    public ResponseEntity<Blog> createDraft(@RequestBody Blog draft, @PathVariable String email) {
        blogService.createDraft(draft, email);
        userService.addDraft(draft);
        return new ResponseEntity<Blog>(draft, HttpStatus.CREATED);
    }

    // Publish Draft
    @PostMapping(value = "/publish/{draft_id}")
    public ResponseEntity<Long> publishDraft(@PathVariable Long draft_id) {
        blogService.publish(draft_id);
        return new ResponseEntity<>(draft_id, HttpStatus.OK);
    }


    // Delete Blog
    @DeleteMapping(value = "/{blog_id}")
    public void deleteBlog(@PathVariable Long blog_id) {
        blogService.deleteBlog(blog_id);
    }

}
