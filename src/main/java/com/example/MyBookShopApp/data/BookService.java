package com.example.MyBookShopApp.data;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
        return author;
    });

        Collections.sort(authors);

        return new ArrayList<>(authors);
    }

    public List<Book> getAllBookByAuthor(Integer authorId) {
        List<Book> books = jdbcTemplate.query("SELECT * FROM books where author_id like ?", new Object[]{authorId}, (ResultSet rs, int rownum)->{
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

    public Author getAuthorById(Integer authorId) { //if(authorRows.next()) поленился прикручивать

        String sql = "SELECT * FROM authors where id = ?";

        return jdbcTemplate.queryForObject(sql, this::makeAuthor, authorId);
    }

    private Author makeAuthor(ResultSet resultSet, int rowNum) throws SQLException {
        int id = resultSet.getInt("id");
        String nameAuthor = resultSet.getString("name_author");
        String biography = resultSet.getString("biography");
      //  System.out.println(id + nameAuthor + biography);
        return new Author(id, nameAuthor, biography);
    }
}
