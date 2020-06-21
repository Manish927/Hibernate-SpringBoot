package manish.bookstore;

import manish.bookstore.service.BookStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ManyToManyInHibernateApplication
{
    @Autowired
    private BookStoreService bookStoreService;

    public static void main(String[] args) {
        SpringApplication.run(ManyToManyInHibernateApplication.class, args);
    }

    @Bean
    public ApplicationRunner init()
    {
        return args -> {
            bookStoreService.insertAuthorsWithBooks();
        };
    }
}
