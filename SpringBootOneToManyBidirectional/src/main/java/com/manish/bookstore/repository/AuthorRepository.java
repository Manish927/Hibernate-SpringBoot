package com.manish.bookstore.repository;

import com.manish.bookstore.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT A FROM Author A JOIN FETCH A.books WHERE A.name = ?1")
    Author fetchByName(String name);
}
