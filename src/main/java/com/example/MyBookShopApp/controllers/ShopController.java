package com.example.MyBookShopApp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ShopController {


    @GetMapping("/documents")
    public String documentsPage() {
        return "/documents/index";
    }

    // Документы — /documents/index.html
    // О компании — /about.html
    // Помощь — /faq.html
    // Контакты — /contacts.html
}
