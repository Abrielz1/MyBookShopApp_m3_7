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

    @GetMapping("/about")
        public String aboutPage() {
            return "/about";
        }

    @GetMapping("/faq")
        public String faqPage() {
            return "/faq";
    }

    @GetMapping("/contacts")
    public String contactsPage() {
        return "/contacts";
    }
}
