package com.manish.bookstore.service;

import com.manish.bookstore.entity.Author;
import com.manish.bookstore.entity.Book;
import com.manish.bookstore.repository.AuthorRepository;
import com.manish.bookstore.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookStoreService {
    public final AuthorRepository authorRepository;

    public BookStoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void insertAuthorWithBooks()
    {
        Author author = new Author();
        author.setName("Alicia Tom");
        author.setAge(36);
        author.setGenre("Anthology");

        Book book = new Book();
        book.setIsbn("001-ATBN");
        book.setTitle("The book of swords");

        author.addBook(book);

        authorRepository.save(author);
    }

    @Transactional
    public void deleteBookOfAuthor()
    {
        Author author = authorRepository.fetchByName("Alicia Tom");
        Book book = author.getBooks().get(0);

        author.removeBook(book);
    }

    @Transactional
    public void deleteAllBooksOfAuthor()
    {
        Author author = authorRepository.fetchByName("Joana Nimar");
        author.removeBooks();
    }

}
