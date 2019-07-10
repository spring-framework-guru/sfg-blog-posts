package guru.springframework.annotationbasedbeandefinitioninheritance.config;

import guru.springframework.annotationbasedbeandefinitioninheritance.domain.Book;
import guru.springframework.annotationbasedbeandefinitioninheritance.domain.EPubBook;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public EPubBook ePubBook() {
        EPubBook ePubBook = new EPubBook();
        initBook(ePubBook);
        ePubBook.setDownloadUrl("http://example.epub.com/books/thinkandgrowrich.epub");
        return ePubBook;
    }

    private void initBook(Book book) {
        book.setBookName("Think and Grow Rich");
        book.setBookPrice(33.99f);
        book.setAuthorName("Napolean Hill");
    }
}
