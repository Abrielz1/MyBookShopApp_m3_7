package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/bookshop")
public class GenresController {

    private final BookService bookService;

    @GetMapping("/genres")
    public String genresPage(Model model){
        return "genres/index";
    }

    @GetMapping("/genres/slug")
    public String genresPageSlug(Model model){
        return "genres/slug";
    }
}
