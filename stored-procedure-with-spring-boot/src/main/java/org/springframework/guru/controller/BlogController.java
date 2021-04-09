package org.springframework.guru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.guru.model.Blog;
import org.springframework.guru.service.BlogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/titleCount")
    public List<Blog> getTotalBlogs(){
        return blogService.getTotalBlogs();
    }

    @GetMapping(path = "/titleCountP")
    public List<Blog> getBlogsByTitle(@RequestParam("blogTitle") String title) {
        return blogService.getBlogsByTitle(title);
    }
}
