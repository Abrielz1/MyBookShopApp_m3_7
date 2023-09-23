package com.example.MyBookShopApp.entity;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Table;

@Data
@Table(name = "books")
public class Book {

    private Integer id;

    @Column(name = "author_id")
    private Integer authorId;

    private String title;

    @Column(name = "price_old")
    private Integer priceOld;

    private Integer price;
}
