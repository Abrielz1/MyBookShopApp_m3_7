package com.example.MyBookShopApp.service;

import com.example.MyBookShopApp.entity.book.entity.Author;
import com.example.MyBookShopApp.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepo repository;

    @Autowired
    public AuthorService(AuthorRepo repository) {
        this.repository = repository;
    }

    public List<Author> getAuthorsData() {
        return repository.findAll();
    }

    public List<Author> findAllAndSortByLastName() {
        return repository.findAllAndSortByLastName();
    }

    public Optional<Author> getAuthor(Long authorId) {
        return repository.findAuthorById(authorId);
    }
}
