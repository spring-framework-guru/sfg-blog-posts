package org.springframework.guru.controller;

import org.springframework.guru.model.Book;
import org.springframework.guru.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/customers")
public class BookController {

    @Resource(name = "bookService")
    BookService bookService;

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable int id) {
        return bookService.getBookById(id);
    }
}