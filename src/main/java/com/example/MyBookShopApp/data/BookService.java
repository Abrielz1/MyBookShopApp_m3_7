package com.example.MyBookShopApp.data;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
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
    List<Author> authors = jdbcTemplate.query("SELECT * FROM AUTHORS", (ResultSet rs, int rowNum) ->{
        Author author = new Author();
        author.setId(rs.getInt("id"));
        author.setNameAuthor(rs.getString("name_author"));
        author.setBiography(rs.getString("biography"));
       // TODO разобраться, как собрать списое книг аффторя
        return author;
    });

        Collections.sort(authors);

        return new ArrayList<>(authors);
    }
}
