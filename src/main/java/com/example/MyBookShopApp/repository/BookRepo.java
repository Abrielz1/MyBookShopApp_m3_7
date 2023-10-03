package com.example.MyBookShopApp.repository;

import com.example.MyBookShopApp.entity.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

    List<Book> findAllByAuthorId(Long authorId);

    //NEW BOOK REST REPOSITORY

    List<Book> findBooksByAuthorFirstNameContaining(String authorsFirstName);

    List<Book> findBooksByTitleContaining(String bookTitle);

    List<Book> findBooksByPriceOldBetween(Integer min, Integer max);

    List<Book> findBooksByPriceOldIs(Integer price);

    @Query("from Book where isBesteller = 1")
    List<Book> getBestsellers();

    //@Query(value = "SELECT * FROM books WHERE discount = (SELECT MAX(discount) FROM books", nativeQuery = true)

    @Query(value = "SELECT * FROM books WHERE discount = (SELECT MAX(discount) FROM books", nativeQuery = true)
    List<Book> getBooksWithMaxDiscount();
}
