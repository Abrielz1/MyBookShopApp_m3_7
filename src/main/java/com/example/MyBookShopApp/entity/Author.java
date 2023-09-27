package com.example.MyBookShopApp.entity;

import lombok.Data;
import javax.persistence.Column;

@Data
public class Author {

    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String patronym;

    private String biography;
}

