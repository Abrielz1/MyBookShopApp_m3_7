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
        model.addAttribute("authorData", bookService.getAuthorData());
        return "index";
    }

//    @GetMapping("/main/genres")
//    public String mainGenres() {
//        return "genres";
//    }
//
//    @GetMapping("/main/authors")
//    public String mainAuthors(){
//        return "authors";
//    }
}
