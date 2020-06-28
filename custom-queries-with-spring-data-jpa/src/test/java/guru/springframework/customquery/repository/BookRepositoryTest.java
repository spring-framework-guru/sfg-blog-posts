package guru.springframework.customquery.repository;

import guru.springframework.customquery.domain.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;
    private Book book1, book2;
    private List<Book> bookList;

    @BeforeEach
    void setUp() {
        book1 = new Book(6, "Time Machine", "Herbert George Wells", true);
        book2 = new Book(7, "Time Machine", "George Wells", false);
        bookRepository.save(book1);
        bookRepository.save(book2);
    }

    @AfterEach
    void tearDown() {
//        bookRepository.deleteAll();
    }


    @Test
    void findBookByTitle() {
        Book fetchedBook = bookRepository.findBookByTitle("I Dare");
        System.out.println(bookRepository.findBookByTitle("I Dare"));
        assertEquals(2, fetchedBook.getId());
    }

    @Test
    void findBookByTitleAndSort() {
        List<Book> actualBookList = bookRepository.findBookByTitleAndSort("Time Machine", Sort.by(Sort.Direction.ASC, "author"));
        assertEquals(0, actualBookList.indexOf(book2));
        assertEquals(1, actualBookList.indexOf(book1));
    }

    //not working
    @Test
    void findBookByArrayAndSort() {
        List<Object[]> list = bookRepository.findBookByArrayAndSort("Kiran Bedi", JpaSort.unsafe("LENGTH(title)"));
        System.out.println(list);
    }

    @Test
    void findBookByTitleAndAuthorIndexJpql() {
        Book actualRetrievedBook = bookRepository.findBookByTitleAndAuthorIndexJpql("Learning Spring Boot", "James Cassy");
        System.out.println(actualRetrievedBook);
        assertEquals(1, actualRetrievedBook.getId());
        assertEquals("Learning Spring Boot", actualRetrievedBook.getTitle());
        assertEquals("James Cassy", actualRetrievedBook.getAuthor());
    }

    @Test
    void findBookByTitleAndAuthorIndexNative() {
        Book actualRetrievedBook = bookRepository.findBookByTitleAndAuthorIndexNative("Development as Freedom", "Amartya Sen");
        System.out.println(actualRetrievedBook);
        assertEquals(3, actualRetrievedBook.getId());
        assertEquals("Development as Freedom", actualRetrievedBook.getTitle());
        assertEquals("Amartya Sen", actualRetrievedBook.getAuthor());
    }

    @Test
    void findBookByTitleAndAuthorNamedJpql() {
        Book actualRetrievedBook = bookRepository.findBookByTitleAndAuthorNamedJpql("Development as Freedom", "Amartya Sen");
        System.out.println(actualRetrievedBook);
        assertEquals(3, actualRetrievedBook.getId());
        assertEquals("Development as Freedom", actualRetrievedBook.getTitle());
        assertEquals("Amartya Sen", actualRetrievedBook.getAuthor());
    }

    @Test
    void findBookByTitleAndAuthorNamedNative() {
        int actualRetrievedBook = bookRepository.findBookByTitleAndAuthorNamedNative("Development as Freedom", "Amartya Sen");
        System.out.println(actualRetrievedBook);
        assertEquals(3, actualRetrievedBook);
    }

    @Test
    void findBookByTitleSPEL() {
        List<Book> list = bookRepository.findBookByTitleSPEL("I Dare");
        System.out.println(list);
    }

    @Test
    void findAllBooksWithPagination() {
        Page<Book> allBookWithPagination = bookRepository.findAllBooksWithPagination(PageRequest.of(0, 3));
        System.out.println(allBookWithPagination);
        assertEquals(3, allBookWithPagination.getTotalPages());
    }

    @Test
    void findAllBooksWithPaginationNative() {
        Page<Book> allBookWithPagination = bookRepository.findAllBooksWithPaginationNative(PageRequest.of(0, 3));
        System.out.println(allBookWithPagination);
        assertEquals(3, allBookWithPagination.getTotalPages());
    }
}