package cn.lic.microservice.base.provider.comp;

import cn.lic.microservice.base.provider.model.Book;
import cn.lic.microservice.base.provider.repos.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class BookRepositoryComp implements BookRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Override
    @Cacheable("books")
    public Book getByIsbn(String isbn) {
        logger.info("getByIsbn -> " + isbn);
        simulateSlowService();
        return new Book(isbn, "Some book");
    }

    // Don't do this at home
    private void simulateSlowService() {
        logger.info("simulateSlowService ...");
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
