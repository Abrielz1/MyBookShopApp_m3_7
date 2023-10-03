package com.example.MyBookShopApp.config;

import org.springframework.stereotype.Component;

@Component
public class ThymeMath {

    public int ceil(int a, int b) {
        return (int) Math.ceil(a * b);
    }
}
