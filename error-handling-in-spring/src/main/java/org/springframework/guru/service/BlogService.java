package org.springframework.guru.service;

import org.springframework.guru.exception.BlogAlreadyExistsException;
import org.springframework.guru.exception.BlogNotFoundException;
import org.springframework.guru.model.Blog;

import java.util.List;

public interface BlogService {

    Blog saveBlog(Blog blog) throws BlogAlreadyExistsException;
    List<Blog> getAllBlogs() throws BlogNotFoundException;
    Blog getBlogById(int id) throws BlogNotFoundException;
}
