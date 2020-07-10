package guru.springframework.customquery.repository;

import guru.springframework.customquery.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

    //Simple query
    @Query("SELECT b FROM Book b")
    List<Book> findAllBooks();

    // Indexed Query Parameters JPQL
    @Query("SELECT b FROM Book b WHERE b.title = ?1 and b.author = ?2")
    Book findBookByTitleAndAuthorIndexJpql(String title, String authorName);

    // Indexed Query Parameters Native
    @Query(value = "SELECT * FROM Book  WHERE title = ?1 and author = ?2",
            nativeQuery = true)
    Book findBookByTitleAndAuthorIndexNative(String title, String authorName);

    // Named Query Parameters JPQL
    @Query("SELECT b FROM Book b WHERE b.title = :title and b.author= :author")
    Book findBookByTitleAndAuthorNamedJpql(@Param("title") String title,
                                           @Param("author") String author);

    // Named Query Parameters Native
    @Query(value = "SELECT * FROM Book WHERE title = :title and author= :author", nativeQuery = true)
    Book findBookByTitleAndAuthorNamedNative(@Param("title") String title, @Param("author") String author);

    // Using Sort
    @Query("select b from Book b where b.title = ?1")
    List<Book> findBookByTitleAndSort(String title, Sort sort);


    //Using SPEL Expression
    @Query("select b from #{#entityName} b where b.title = ?1")
    List<Book> findBookByTitleSPEL(String title);


    //Using SPEL Expression wildcard shortcut.
    @Query("select b from Book b where b.title like %:#{[0]}% and b.author like %:author%")
    List<Book> findByAuthorWithSpelExpression(@Param("author") String author);


    //    Using pagination in the JPQL query - HQL
    @Query(value = "SELECT b FROM Book b ORDER BY title")
    Page<Book> findAllBooksWithPagination(Pageable pageable);


    //    Using pagination in the JPQL query - Native
    @Query(value = "SELECT * FROM Book ORDER BY id",
            countQuery = "SELECT count(*) FROM Book",
            nativeQuery = true)
    Page<Book> findAllBooksWithPaginationNative(Pageable pageable);
}
