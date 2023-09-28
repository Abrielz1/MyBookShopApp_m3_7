package com.example.MyBookShopApp.repository;

import com.example.MyBookShopApp.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {

    @Query("select author from Author author" +
            " order by author.lastName")
    List<Author> findAllAndSortByLastName();

    Optional<Author> findAuthorById(Long authorID);
}
