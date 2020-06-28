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
                .title("I Dare")
                .author("Kiran Bedi")
                .status(false)
                .build();
        Book book3=Book.builder()
                .title("Development as Freedom")
                .author("Amartya Sen")
                .status(false)
                .build();
        Book book4=Book.builder()
                .title("Clear City of the Day")
                .author("Anita Desai")
                .status(false)
                .build();
        Book book5=Book.builder()
                .title("The Argumentative Indian")
                .author("Amartya Sen")
                .status(false)
                .build();
        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
        bookRepository.save(book4);
        bookRepository.save(book5);
        log.info("Inserted book1, book2...");

    }
}
