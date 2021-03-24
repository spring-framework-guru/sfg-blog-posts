package org.springframework.guru.controller;

import org.springframework.guru.exception.BlogAlreadyExistsException;
import org.springframework.guru.exception.BlogNotFoundException;
import org.springframework.guru.model.Blog;
import org.springframework.guru.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class BlogController {
    private BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/blog")
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog) throws BlogAlreadyExistsException {
        Blog savedBlog = blogService.saveBlog(blog);
        return new ResponseEntity<>(savedBlog, HttpStatus.CREATED);

    }

    @GetMapping("/blogs")
    public ResponseEntity<List<Blog>> getAllBlogs() throws BlogNotFoundException {
        return new ResponseEntity<List<Blog>>((List<Blog>) blogService.getAllBlogs(), HttpStatus.OK);
    }

    @GetMapping("blog/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable("id") int id) throws BlogNotFoundException {
        return new ResponseEntity<Blog>(blogService.getBlogById(id), HttpStatus.OK);
    }

    @ExceptionHandler(value = BlogAlreadyExistsException.class)
    public ResponseEntity<String> BlogAlreadyExistsException(BlogAlreadyExistsException blogAlreadyExistsException) {
        return new ResponseEntity<String>("Blog already exists", HttpStatus.CONFLICT);
    }
}
