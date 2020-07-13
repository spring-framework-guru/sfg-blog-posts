package guru.springframework.customquery.repository;

import guru.springframework.customquery.domain.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasProperty;

@DataJpaTest
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;
    private Book book1, book2;
    private List<Book> bookList;

    @BeforeEach
    void setUp() {
        Book book1=Book.builder()
                .isbn("0-2169-6768-6")
                .title("I Dare")
                .author("James Cassy")
                .status(true)
                .build();
        Book book2=Book.builder()
                .isbn("0-5395-2414-X")
                .title("I Dare")
                .author("Patrick")
                .status(false)
                .build();
        Book book3=Book.builder()
                .isbn("0-2139-7448-7")
                .title("Time Machine")
                .author("Herbert Neil")
                .status(false)
                .build();
        Book book4=Book.builder()
                .isbn("0-4572-6998-3")
                .title("Time Machine")
                .author("George Wells")
                .status(false)
                .build();

        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
        bookRepository.save(book4);
    }

    @AfterEach
    void tearDown() {
       bookRepository.deleteAll();
    }


    @Test
    void findAllBooks() {
        List<Book> result = bookRepository.findAllBooks();
        assertThat(result, is(notNullValue()));
    }

    @Test
    void findBookByTitleAndAuthorIndexJpql() {
        Book actualRetrievedBook = bookRepository.findBookByTitleAndAuthorIndexJpql("I Dare", "James Cassy");
        assertThat(actualRetrievedBook, is(notNullValue()));
        assertThat(actualRetrievedBook.getIsbn(), is("0-2169-6768-6"));
    }

    @Test
    void findBookByTitleAndAuthorIndexNative() {
        Book actualRetrievedBook = bookRepository.findBookByTitleAndAuthorIndexNative("I Dare", "James Cassy");
        assertThat(actualRetrievedBook, is(notNullValue()));
        assertThat(actualRetrievedBook.getIsbn(), is("0-2169-6768-6"));
    }


    @Test
    void findBookByTitleAndAuthorNamedJpql() {
        Book actualRetrievedBook = bookRepository.findBookByTitleAndAuthorNamedJpql("I Dare", "James Cassy");
        assertThat(actualRetrievedBook, is(notNullValue()));
        assertThat(actualRetrievedBook.getIsbn(), is("0-2169-6768-6"));
    }

    @Test
    void findBookByTitleAndAuthorNamedNative() {
        Book actualRetrievedBook = bookRepository.findBookByTitleAndAuthorNamedNative("I Dare", "James Cassy");
        assertThat(actualRetrievedBook, is(notNullValue()));
        assertThat(actualRetrievedBook.getIsbn(), is("0-2169-6768-6"));
    }

    @Test
    void findBookByTitleAndSort() {
        List<Book> actualBookList = bookRepository.findBookByTitleAndSort("Time Machine",Sort.by("author").descending());
        assertThat(actualBookList.size(), is(2));
        assertThat(actualBookList, containsInAnyOrder(
                hasProperty("author", is("George Wells")),
                hasProperty("author", is("Herbert Neil"))
        ));
    }

    @Test
    void findBookByTitleSPEL() {
        List<Book> actualBookList = bookRepository.findBookByTitleSPEL("I Dare");
        assertThat(actualBookList.size(), is(2));
    }

    @Test
    void findAllBooksWithPagination() {
        Page<Book> allBookWithPagination = bookRepository.findAllBooksWithPagination(PageRequest.of(0, 3));
        assertThat(allBookWithPagination.getTotalPages(), is(2));
    }

    @Test
    void findAllBooksWithPaginationNative() {
        Page<Book> allBookWithPagination = bookRepository.findAllBooksWithPaginationNative(PageRequest.of(0, 3));
        assertThat(allBookWithPagination.getTotalPages(), is(2));

    }
}