package com.example.MyBookShopApp.dto;

import com.example.MyBookShopApp.entity.book.entity.Book;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
public class BooksPageDto {

    private Integer count;
    private List<Book> books;

    public BooksPageDto(List<Book> books) {
        this.books = books;
        this.count = books.size();
    }
}
