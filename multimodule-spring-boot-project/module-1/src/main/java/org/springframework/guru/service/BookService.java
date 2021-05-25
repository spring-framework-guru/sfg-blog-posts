package org.springframework.guru.service;

import org.springframework.guru.model.Book;

public interface BookService {
    Book getBookById(final int id);
}
