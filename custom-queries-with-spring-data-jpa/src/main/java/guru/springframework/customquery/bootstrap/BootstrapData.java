package guru.springframework.customquery.bootstrap;

import guru.springframework.customquery.domain.Book;
import guru.springframework.customquery.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BootstrapData implements CommandLineRunner {

    private BookRepository bookRepository;
    @Autowired
    public BootstrapData(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        Book book1=Book.builder()
                .title("Learning Spring Boot")
                .author("James Cassy")
                .status(true)
                .build();
        Book book2=Book.builder()
                .title("CI/CD in the Enterprise")
                .author("Meghna N")
                .status(false)
                .build();
        //Add more books

        bookRepository.save(book1);
        bookRepository.save(book2);
        log.info("Inserted book1, book2...");

    }
}
