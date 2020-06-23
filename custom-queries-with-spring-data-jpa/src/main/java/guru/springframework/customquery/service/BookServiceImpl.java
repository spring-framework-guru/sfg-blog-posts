package guru.springframework.customquery.service;

import guru.springframework.customquery.domain.Book;
import guru.springframework.customquery.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository=bookRepository;
    }

    @Override
    public Book saveBook(Book book) {
        logger.info(book.toString());
        return bookRepository.save(book);
    }

    @Override
    public Book findBookByName(String name) {
        logger.info(name);
        return bookRepository.findBookByName(name);
    }



}
