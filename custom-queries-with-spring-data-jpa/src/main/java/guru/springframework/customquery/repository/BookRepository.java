package guru.springframework.customquery.repository;

import guru.springframework.customquery.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
    @Query("FROM Book WHERE name = ?1")
    Book findBookByName(String name);
    
}
