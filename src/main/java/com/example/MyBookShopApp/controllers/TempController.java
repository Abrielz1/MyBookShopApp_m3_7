package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.entity.Author;
import com.example.MyBookShopApp.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor

public class TempController {
    //TODO:
    // Новинки — файл /books/recent.html
    // Популярное — /books/popular.html
    // Отложенное — /postponed.html
    // Авторы — /authors/index.html \/
    // Книги по жанру — /genres/index.html \/
    // Корзина — /cart.html
    // Войти — /signin.html
    // Поиск — /search/index.html
    // Документы — /documents/index.html
    // О компании — /about.html
    // Помощь — /faq.html
    // Контакты — /contacts.html

    private final AuthorService authorService;



    // "/books/recent"

    // "/books/popular"


}
