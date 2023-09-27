package com.example.MyBookShopApp.service;

import com.example.MyBookShopApp.entity.Author;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AuthorService {

    private JdbcTemplate jdbcTemplate;

    public List<Author> getAuthorsData() {

        List<Author> authors = jdbcTemplate.query("SELECT * FROM authors", (ResultSet rs, int rownum) -> {

            Author author = new Author();

            author.setId(rs.getInt("id"));
            author.setFirstName(rs.getString("first_name"));
            author.setLastName(rs.getString("last_name"));
            author.setPatronym(rs.getString("patronym"));
            author.setBiography(rs.getString("biography"));

            return author;
        });

        return new ArrayList<>(authors);
    }

    public Author getAuthor(Integer id) {

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);

        Author result = jdbcTemplate.queryForObject("SELECT * FROM authors WHERE id = ?", new Object[]{id}, (ResultSet rs, int rownum) -> {

            Author author = new Author();

            author.setId(rs.getInt("id"));
            author.setFirstName(rs.getString("first_name"));
            author.setLastName(rs.getString("last_name"));
            author.setPatronym(rs.getString("patronym"));
            author.setBiography(rs.getString("biography"));

            return author;
        });

        return result;
    }
}
