package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.entity.book.entity.Author;
import com.example.MyBookShopApp.entity.book.entity.Book;
import com.example.MyBookShopApp.service.AuthorService;
import com.example.MyBookShopApp.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainPageController {

    private final BookService bookService;

    private final AuthorService authorService;

    @ModelAttribute("allAuthorsList")
    public List<Author> allAuthorsList() {
        return authorService.getAuthorsData();
    }

    @ModelAttribute("recommendedBooks")
    public List<Book> recommendedBooks() {
        return bookService.getBooksData();
    }


    @GetMapping("/")
    public String mainPage(){
        return "index";
    }

    //TODO:
    // Подключить постраничный вывод для лент «Новинки»
    // Популярное» на главной странице

}
