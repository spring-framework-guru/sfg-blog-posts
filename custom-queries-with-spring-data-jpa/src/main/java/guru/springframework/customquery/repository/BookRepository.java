package guru.springframework.customquery.repository;

import guru.springframework.customquery.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Indexed;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

    //Simple query

    @Query("SELECT b FROM Book b WHERE b.title = ?1")
    Book findBookByTitle(String title);

// Using Sort
//    @Query("select b from User u where u.lastname like ?1%")
//    List<User> findByAndSort(String lastname, Sort sort);
//
//    @Query("select u.id, LENGTH(u.firstname) as fn_len from User u where u.lastname like ?1%")
//    List<Object[]> findByAsArrayAndSort(String lastname, Sort sort);
//}
//
//repo.findByAndSort("lannister", new Sort("firstname"));
//        repo.findByAndSort("stark", new Sort("LENGTH(firstname)"));
//        repo.findByAndSort("targaryen", JpaSort.unsafe("LENGTH(firstname)"));
//        repo.findByAsArrayAndSort("bolton", new Sort("fn_len"));


// Indexed Query Parameters JPQL
    @Query("SELECT b FROM Book b WHERE b.title = ?1 and b.author = ?2")
    Book findBookByTitleAndAuthorIndexJpql(String title, String authorName);


    // Indexed Query Parameters Native
    @Query(
            value = "SELECT * FROM Book b WHERE b.title = ?1 and b.author = ?2",
            nativeQuery = true)
    Book findBookByTitleAndAuthorIndexNative(String title, String authorName);


    // Named Query Parameters JPQL
    @Query("SELECT b FROM Book b WHERE b.title = :title and b.author= :author")
    Book findBookByTitleAndAuthorNamedJpql(@Param("title") String title,
                                           @Param("author") String author);


    // Named Query Parameters Native
    @Query(value = "SELECT b FROM Book b WHERE b.title = :title and b.author= :author", nativeQuery = true)
    Book findBookByTitleAndAuthorNamedNative(@Param("title") String title,
                                           @Param("author") String author);



    //Using SPEL Expression
//    public interface UserRepository extends JpaRepository<User,Long> {
//
//        @Query("select u from #{#entityName} u where u.lastname = ?1")
//        List<User> findByLastname(String lastname);
//    }

    //Using SPEL Expression wildcard shortcut.

//    @Query("select u from User u where u.lastname like %:#{[0]}% and u.lastname like %:lastname%")
//    List<User> findByLastnameWithSpelExpression(@Param("lastname") String lastname);


//    Using pagination in the JPQL query - HQL

//    @Query(value = "SELECT u FROM User u ORDER BY id")
//    Page<User> findAllUsersWithPagination(Pageable pageable);


    //    Using pagination in the JPQL query - Native

//    @Query(
//            value = "SELECT * FROM Users ORDER BY id",
//            countQuery = "SELECT count(*) FROM Users",
//            nativeQuery = true)
//    Page<User> findAllUsersWithPagination(Pageable pageable);
}
