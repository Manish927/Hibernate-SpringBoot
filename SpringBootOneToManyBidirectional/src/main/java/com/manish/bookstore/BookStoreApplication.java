package com.manish.bookstore;

import com.manish.bookstore.service.BookStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstoreApplication {

    private final BookStoreService bookStoreService;

    public BookstoreApplication(BookStoreService bookStoreService) {
        this.bookStoreService = bookStoreService;
    }

    public static void main(String[] args) {

        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Bean
    public ApplicationRunner init()
    {
        return args -> {
            System.out.println("Insert Author with books...");
            bookStoreService.insertAuthorWithBooks();

            System.out.println("Delete a book of an author...");
            bookStoreService.deleteBookOfAuthor();

            System.out.println("Delete all book of an author");
            bookStoreService.deleteAllBooksOfAuthor();
        };
    }

}
