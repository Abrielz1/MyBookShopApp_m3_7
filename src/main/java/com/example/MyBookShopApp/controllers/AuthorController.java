package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.entity.Author;
import com.example.MyBookShopApp.entity.Book;
import com.example.MyBookShopApp.service.AuthorService;
import com.example.MyBookShopApp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/bookshop")
public class AuthorController {

    private final AuthorService authorService;
    private final BookService bookService;

    @Autowired
    public AuthorController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @GetMapping("/authors")
    public String authorsPage(Model model) {
        List<Author> authors = authorService.getAuthorsData();
        Collections.sort(authors, Comparator.comparing(Author::getLastName));
        Map<Character, List<Author>> authorsData = new HashMap<>();
        for (Author author: authors) {
            Character letter = Character.toLowerCase(author.getLastName().charAt(0));
            if (authorsData.get(letter) == null) {
                authorsData.put(letter, new ArrayList<>(Arrays.asList(author)));
            } else {
                List<Author> groupAuthors = authorsData.get(letter);
                groupAuthors.add(author);
                authorsData.put(letter, groupAuthors);
            }
        }
        model.addAttribute("authorsData", authorsData);
        return "authors/index";
    }

    @GetMapping("/authors/slug")
    public String authorsPageSlug(@RequestParam(value = "authorId") Integer authorId, Model model) {
        Author author =  authorService.getAuthor(authorId);
        List<Book> books = bookService.getBooksByAuthor(authorId);
        model.addAttribute("author", author);
        model.addAttribute("books", books);
        return "authors/slug";
    }
}
