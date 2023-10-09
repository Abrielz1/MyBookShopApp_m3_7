package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.entity.book.entity.Author;
import com.example.MyBookShopApp.entity.book.entity.Book;
import com.example.MyBookShopApp.service.AuthorService;
import com.example.MyBookShopApp.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(description = "authors data")
@Controller
//@RequiredArgsConstructor()
public class AuthorController {

    private final AuthorService authorService;

    private final BookService bookService;

    @Autowired //снести
    public AuthorController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @ApiOperation("method for acquiring list of all authors," +
            " sorted and ordered by first letter their last name")
    @ModelAttribute("authorsData")
    public Map<Character,List<Author>> authorsCharMap() {

        List<Author> authors = authorService.findAllAndSortByLastName();

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


    @ApiOperation("method for acquiring list of all authors")
    @GetMapping("/authors")
    public String authorsPage() {
        return "authors/index";
    }


    @ApiOperation("method for acquiring list of all books by author")
    @GetMapping("/authors/slug")
    public String authorsPageSlug(@RequestParam(value = "authorId") Long authorId, Model model) {
        Author author =  authorService.getAuthor(authorId).get();
        List<Book> books = bookService.getBooksByAuthor(authorId);
        model.addAttribute("author", author);
        model.addAttribute("books", books);
        return "authors/slug";
    }


    @ApiOperation("method for acquiring list of all authors in db")
    @GetMapping("/api/authors")
    @ResponseBody
    public List<Author> authors() {
        return authorService.getAuthorsData();
    }
}
