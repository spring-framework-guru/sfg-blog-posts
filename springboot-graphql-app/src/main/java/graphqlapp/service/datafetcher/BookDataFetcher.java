package graphqlapp.service.datafetcher;

import graphql.schema.DataFetcher;
import graphqlapp.model.Book;
import graphqlapp.repository.BookRepository;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookDataFetcher implements DataFetcher<Book> {

    private BookRepository bookRepository;

    @Autowired
    public BookDataFetcher(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public Book get(DataFetchingEnvironment dataFetchingEnvironment) {
        String isn = dataFetchingEnvironment.getArgument("id");
        return bookRepository.findById(isn).orElse(null);
    }
}
