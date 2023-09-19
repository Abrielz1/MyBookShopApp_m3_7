package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
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
    public String authorsPage(){
        return "/genres/index";
    }

//    @GetMapping("/genres")
//    public String mainGenres() {
//        return "/genres/index";
//    }

    @GetMapping("/authors")
    public String mainAuthors(Model model){
        model.addAttribute("authorData", bookService.getAuthorData());
        return "authors";
    }
}
