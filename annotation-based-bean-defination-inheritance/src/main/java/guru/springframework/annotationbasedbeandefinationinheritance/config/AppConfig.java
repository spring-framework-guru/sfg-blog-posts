package guru.springframework.annotationbasedbeandefinationinheritance.config;

import guru.springframework.annotationbasedbeandefinationinheritance.domain.Book;
import guru.springframework.annotationbasedbeandefinationinheritance.domain.EPubBook;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public EPubBook ePubBook() {
        EPubBook ePubBook = new EPubBook();
        initBook(ePubBook);
        ePubBook.setDownloadUrl("example.epub.com");
        return ePubBook;
    }

    private void initBook(Book book) {
        book.setBookName("Start Where You Are");
        book.setBookPrice(400);
        book.setAuthorName("Meera Lee Patel");
    }
}
