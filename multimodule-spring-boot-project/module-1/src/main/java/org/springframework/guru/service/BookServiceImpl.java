package org.springframework.guru.service;

import org.springframework.guru.model.Book;
import org.springframework.stereotype.Service;

@Service("bookService")
public class BookServiceImpl implements BookService {

    @Override
    public Book getBookById(int id) {
        return new Book(101,"OOPS Programming","Timothy Budd");
    }
}