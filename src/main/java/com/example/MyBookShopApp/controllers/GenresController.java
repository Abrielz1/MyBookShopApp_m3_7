package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class GenresController {

    @GetMapping("/genres")
    public String genresPage(){
        return "genres/index";
    }

    @GetMapping("/genres/slug")
    public String genresPageSlug(){
        return "genres/slug";
    }
}
