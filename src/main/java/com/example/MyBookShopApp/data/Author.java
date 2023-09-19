package com.example.MyBookShopApp.data;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.List;

@Data
@Table(name = "authors")
public class Author implements Comparable<Author> {

    private Integer id;

    @Column(name = "name_author")
    private String nameAuthor;

    @Column(name = "biography")
    private String biography;

    @Override
    public int compareTo(Author o) {
        return this.getNameAuthor().compareTo(o.getNameAuthor());
    }

    //   private List<Book> books;

}
