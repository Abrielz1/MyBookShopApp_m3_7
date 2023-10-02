package com.example.MyBookShopApp.service;

import com.example.MyBookShopApp.entity.book.entity.Book;
import com.example.MyBookShopApp.exceptions.ObjectNotFoundException;
import com.example.MyBookShopApp.repository.AuthorRepo;
import com.example.MyBookShopApp.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    private final AuthorRepo authorRepo;

    private final BookRepo repository;

    @Autowired
    public BookService(AuthorRepo authorRepo, BookRepo repository) {
        this.authorRepo = authorRepo;
        this.repository = repository;
    }

    public List<Book> getBooksData() {
        return repository.findAll();
    }

    public List<Book> getBooksByAuthor(Long authorId) {

        authorRepo.findById(authorId).orElseThrow(() ->
                new ObjectNotFoundException("Author not found!"));

        return repository.findAllByAuthorId(authorId);
    }
}
