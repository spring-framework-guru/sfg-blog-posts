package org.springframework.guru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.guru.repository.BlogRepository;
import org.springframework.stereotype.Service;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    public int getTotalBlogsByTitle(String title) {
        return blogRepository.getTotalBlogsByTitle(title);
    }

    public int getTotalBlogsByTitleProcedureName(String title) {
        return blogRepository.getTotalBlogsByTitleProcedureName(title);
    }

    public int getTotalBlogsByTitleValue(String title) {
        return blogRepository.getTotalBlogsByTitleValue(title);
    }

    public int getTotalBlogsByTitleExplicit(String title) {
        return blogRepository.GET_TOTAL_BLOGS_BY_TITLE(title);
    }

    public int getTotalBlogsByTitleEntity(String title) {
        return blogRepository.getTotalBlogsByTitleEntiy(title);
    }

}