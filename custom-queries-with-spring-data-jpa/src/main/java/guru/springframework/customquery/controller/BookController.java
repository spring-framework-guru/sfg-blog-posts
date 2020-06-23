package guru.springframework.customquery.controller;

import guru.springframework.customquery.domain.Book;
import guru.springframework.customquery.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("book")
    public Book saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @GetMapping("book/{name}")
    public Book findBookByName(@PathVariable("name") String name) {
        return bookService.findBookByName(name);
    }

    @GetMapping("books")
    public List<Book> findAllBooks() {
        return bookService.findAllBooks();
    }
}
