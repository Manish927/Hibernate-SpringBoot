package com.manish.bookstore.repository;

import com.manish.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import javax.transaction.Transactional;

@NoRepositoryBean
@Transactional
public interface BookBaseRepository<T extends Book> extends JpaRepository<T, Long> {

    T findByTitle(String title);

    @Query(value = "SELECT b FROM #{#entityName} AS b WHERE b.isbn = ?1")
    T fetchByIsbn(String isbn);
}
