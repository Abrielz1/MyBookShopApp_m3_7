package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.entity.Author;
import com.example.MyBookShopApp.entity.Book;
import com.example.MyBookShopApp.service.AuthorService;
import com.example.MyBookShopApp.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor()

public class AuthorController {

    private final AuthorService authorService;

    private final BookService bookService;


    @ModelAttribute("authorsData")
    public Map<Character,List<Author>> authorsCharMap() {

        List<Author> authors = authorService.getAuthorsData();

        authors.sort(Comparator.comparing(Author::getLastName));

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

        return authorsData;
    }


    @GetMapping("/authors")
    public String authorsPage() {
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


//    @ModelAttribute("authorsModel")
//    public List<Book> authorsPageModel(@RequestParam(value = "authorId") Integer authorId) {
//       // Map<Author, List<Book>> authorsModel = new HashMap<>();
//        Author author =  authorService.getAuthor(authorId);
//       // List<Book> authorsModel = bookService.getBooksByAuthor(authorId);
//        //authorsModel.put(author, books);
//
//        return bookService.getBooksByAuthor(authorId);
//    }
//
//    @GetMapping("/authors/slug")
//    public String authorsPageSlug() {
//
//        return "authors/slug";
//    }
}
