package org.springframework.guru.service;

import org.springframework.guru.exception.BlogAlreadyExistsException;
import org.springframework.guru.exception.BlogNotFoundException;
import org.springframework.guru.model.Blog;
import org.springframework.guru.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    private BlogRepository blogRepository;

    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public Blog saveBlog(Blog blog) {
        if (blogRepository.existsById(blog.getBlogId())) {
            throw new BlogAlreadyExistsException();
        }
        Blog savedBlog = blogRepository.save(blog);
        return savedBlog;
    }

    @Override
    public List<Blog> getAllBlogs() {
        return (List<Blog>) blogRepository.findAll();
    }

    @Override
    public Blog getBlogById(int id) throws BlogNotFoundException {
        Blog blog;
        if (blogRepository.findById(id).isEmpty()) {
            throw new BlogNotFoundException();
        } else {
            blog = blogRepository.findById(id).get();
        }
        return blog;
    }
}
