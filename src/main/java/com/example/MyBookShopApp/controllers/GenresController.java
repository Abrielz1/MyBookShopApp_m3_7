package com.example.MyBookShopApp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
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
