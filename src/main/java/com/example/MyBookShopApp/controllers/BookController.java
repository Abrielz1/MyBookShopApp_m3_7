package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.entity.book.entity.Author;
import com.example.MyBookShopApp.entity.book.entity.Book;
import com.example.MyBookShopApp.service.AuthorService;
import com.example.MyBookShopApp.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    private final AuthorService authorService;

//    @Autowired
//    public BookController(BookService bookService, AuthorService authorService) {
//        this.bookService = bookService;
//        this.authorService = authorService;
//    }

    @ModelAttribute("booksList")
    public List<Book> bookList() {
        return bookService.getBooksData();
    }

    @ModelAttribute("authorsList")
    public List<Author> authorsList() {
        return authorService.getAuthorsData();
    }

    @GetMapping("/recent")
    public String recentPage() {
        return "/books/recent";
    }

    @GetMapping("/popular")
    public String popularPage() {
        return "/books/popular";
    }

    @GetMapping("/postponed")
    public String postponedPage() {
        return "/postponed";
    }

    @GetMapping("/cart")
    public String cartPage() {
        return "/cart";
    }

    @GetMapping("/search")
    public String searchPage() {
        return "/search/index";
    }
}
