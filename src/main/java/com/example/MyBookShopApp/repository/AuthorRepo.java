package com.example.MyBookShopApp.repository;

import com.example.MyBookShopApp.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {
    Optional<Author> findAuthorById(Long authorID);
}
