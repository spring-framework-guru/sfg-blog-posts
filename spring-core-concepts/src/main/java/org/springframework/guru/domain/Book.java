package org.springframework.guru.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Book {
    private String bookTitle;
    private String bookType;
    BookPublisher bookPublisher;

    public Book() {
    }

    @Autowired
    public Book(BookPublisher bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public Book(String bookTitle, String bookType, BookPublisher bookPublisher) {
        this.bookTitle = bookTitle;
        this.bookType = bookType;
        this.bookPublisher = bookPublisher;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public BookPublisher getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(BookPublisher bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookTitle='" + bookTitle + '\'' +
                ", bookType='" + bookType + '\'' +
                ", bookPublisher=" + bookPublisher +
                '}';
    }
}
