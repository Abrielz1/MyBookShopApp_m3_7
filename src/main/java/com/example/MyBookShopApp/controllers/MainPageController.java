package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.Author;
import com.example.MyBookShopApp.data.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Validated
@RequestMapping("/bookshop")
@RequiredArgsConstructor
public class MainPageController {

    private final BookService bookService;

    @GetMapping("/main")
    public String mainPage(Model model){
        model.addAttribute("bookData", bookService.getBooksData());
        return "index";
    }

    @GetMapping("/genres")
    public String mainsGenres(){
        return "/genres/index";
    }


    @GetMapping("/authors")
    public String mainAuthors(Model model){
        List<Author> authors = bookService.getAuthorData();
        Map<Character, List<Author>> authorsData = new HashMap<>();
        for (Author i : authors) {
            char firstLetter = Character.toLowerCase(i.getNameAuthor().charAt(0));
            if (authorsData.get(firstLetter) == null) {
                authorsData.put(firstLetter, new ArrayList<>(List.of(i)));
            } else {
                List<Author> dump = authorsData.get(firstLetter);
                dump.add(i);
                authorsData.put(firstLetter, dump);
            }
        }
        model.addAttribute("authorsData", authorsData);
        return "/authors/index";
    }

    @GetMapping("/authors/slug")
    public String mainBooksByAuthor(@RequestParam(value = "authorId") Integer authorId, Model model) {

        return "/authors/slug";
    }
}
