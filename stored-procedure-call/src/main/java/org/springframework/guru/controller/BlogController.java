package org.springframework.guru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.guru.service.BlogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping(path = "/titleCount")
    public long getTotalBlogsByTitle(@RequestParam("title") String title) {
        return blogService.getTotalBlogsByTitle(title);
    }

    @GetMapping(path = "/titleCountP")
    public long getTotalBlogsByTitleProcedureName(@RequestParam("title") String title) {
        return blogService.getTotalBlogsByTitleProcedureName(title);
    }

    @GetMapping(path = "/titleCountV")
    public long getTotalBlogsByValue(@RequestParam("title") String title) {
        return blogService.getTotalBlogsByTitleValue(title);
    }

    @GetMapping(path = "/titleCountEx")
    public long getTotalBlogsByTitleExplicit(@RequestParam("title") String title) {
        return blogService.getTotalBlogsByTitleExplicit(title);
    }

    @GetMapping(path = "/titleCountEn")
    public long getTotalBlogsByTitleEntity(@RequestParam("title") String title) {
        return blogService.getTotalBlogsByTitleEntity(title);
    }

}
