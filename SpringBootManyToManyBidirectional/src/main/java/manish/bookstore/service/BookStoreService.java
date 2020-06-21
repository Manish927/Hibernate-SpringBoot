package manish.bookstore.service;

import manish.bookstore.entity.Author;
import manish.bookstore.entity.Book;
import manish.bookstore.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookStoreService {
    private final AuthorRepository authorRepository;

    public BookStoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Transactional
    public void insertAuthorsWithBooks()
    {
        Author alicia = new Author();
        alicia.setName("Alicia Tom");
        alicia.setAge(38);
        alicia.setGenre("Anthology");

        Author mark = new Author();
        mark.setName("Mark Janel");
        mark.setAge(23);
        mark.setGenre("Anthology");

        Book bookOfSwords = new Book();
        bookOfSwords.setIsbn("001-AT-MJ");
        bookOfSwords.setTitle("The book of swords");

        Book oneDay = new Book();
        oneDay.setIsbn("002-AT-MJ");
        oneDay.setTitle("One Day");

        alicia.addBook(bookOfSwords);
        mark.addBook(oneDay);

        authorRepository.save(alicia);
        authorRepository.save(mark);
    }

}
