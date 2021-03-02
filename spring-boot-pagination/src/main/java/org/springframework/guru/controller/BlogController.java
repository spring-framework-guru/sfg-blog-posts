package org.springframework.guru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.guru.model.Blog;
import org.springframework.guru.repository.BlogRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;
    @GetMapping(value = "/blogPageable")
    Page<Blog> blogPageable(Pageable pageable) {
        return blogRepository.findAll(pageable);

    }
}
