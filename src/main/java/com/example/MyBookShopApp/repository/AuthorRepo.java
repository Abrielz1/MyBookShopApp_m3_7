package com.example.MyBookShopApp.repository;

import com.example.MyBookShopApp.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author, Long> {
}
