package com.example.MyBookShopApp.service;

import com.example.MyBookShopApp.entity.Author;
import com.example.MyBookShopApp.entity.Book;
import com.example.MyBookShopApp.exceptions.ObjectNotFoundException;
import com.example.MyBookShopApp.repository.AuthorRepo;
import com.example.MyBookShopApp.repository.BookRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final AuthorRepo authorRepo;

    private final BookRepo repository;

    public List<Book> getBooksData() {
        return repository.findAll();
    }

    public List<Book> getBooksByAuthor(Long authorId) {
        Author author = authorRepo.findById(authorId).orElseThrow(()->
                new ObjectNotFoundException("Author not found!"));
        return repository.findAllByAuthorId(authorId);
    }
}
