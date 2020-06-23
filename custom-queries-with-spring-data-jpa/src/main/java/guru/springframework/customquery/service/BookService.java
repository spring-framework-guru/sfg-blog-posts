package guru.springframework.customquery.service;

import guru.springframework.customquery.domain.Book;
import java.util.List;

public interface BookService {
    Book saveBook(Book book);
    Book findBookByName(String name);
}
