package com.example.MyBookShopApp.data;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final JdbcTemplate jdbcTemplate;

    public List<Book> getBooksData(){

        List<Book> books = jdbcTemplate.query("SELECT * FROM books", (ResultSet rs, int rowNum)->{
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setAuthorId(rs.getInt("author_id"));
            book.setTitle(rs.getString("title"));
            book.setPriceOld(rs.getInt("price_old"));
            book.setPrice(rs.getInt("price"));
            return book;
        });
        return new ArrayList<>(books);
    }

    public List<Author> getAuthorData() {
    List<Author> authors = jdbcTemplate.query("", (ResultSet rs, int rowNum) ->{
        Author author = new Author();
        author.setId(rs.getInt("id"));
        author.setNameAuthor(rs.getString("name_author"));
        author.setBiography(rs.getString("title"));
       // author.setBooks(rs.getArray(List<Book>));
        return author;
    });
        return new ArrayList<>(authors);
    }
}
