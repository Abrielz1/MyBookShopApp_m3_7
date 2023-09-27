package com.example.MyBookShopApp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/bookshop")
public class UserController {

    //TODO

    @GetMapping("/signin")
    public String signinPage(){
        return "signin";
    }

    @GetMapping("/signup")
    public String signupPage(){
        return "signup";
    }
}