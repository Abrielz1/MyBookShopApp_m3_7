package com.example.MyBookShopApp.service;

import com.example.MyBookShopApp.entity.book.entity.Author;
import com.example.MyBookShopApp.repository.AuthorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepo repository;

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
