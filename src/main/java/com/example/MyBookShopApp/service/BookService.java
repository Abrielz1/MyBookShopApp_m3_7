package com.example.MyBookShopApp.service;

import com.example.MyBookShopApp.entity.book.entity.Book;
import com.example.MyBookShopApp.exceptions.ObjectNotFoundException;
import com.example.MyBookShopApp.repository.AuthorRepo;
import com.example.MyBookShopApp.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.util.List;

@Service
public class BookService {

    private final AuthorRepo authorRepo;

    private final BookRepo repository;

    @Autowired
    public BookService(AuthorRepo authorRepo, BookRepo repository) {
        this.authorRepo = authorRepo;
        this.repository = repository;
    }

    public List<Book> getBooksData() {
        return repository.findAll();
    }

    public List<Book> getBooksByAuthor(Long authorId) {

        authorRepo.findById(authorId).orElseThrow(() ->
                new ObjectNotFoundException("Author not found!"));

        return repository.findAllByAuthorId(authorId);
    }

    //NEW BOOK SERVICE METHODS

    public List<Book> getBooksByAuthor(String authorName){
        return repository.findBooksByAuthorFirstNameContaining(authorName);
    }

    public List<Book> getBooksByTitle(String title){
        return repository.findBooksByTitleContaining(title);
    }

    public List<Book> getBooksWithPriceBetween(Integer min, Integer max){
        return repository.findBooksByPriceOldBetween(min,max);
    }

    //TODO реализовать метод в контроллере и по возможности в морде
    public List<Book> getBooksWithPrice(Integer price){
        return repository.findBooksByPriceOldIs(price);
    }

    public List<Book> getBooksWithMaxPrice(){
        return repository.getBooksWithMaxDiscount();
    }

    public List<Book> getBestsellers(){
        return repository.getBestsellers();
    }

    public Page<Book> getPageOfRecommendedBooks(Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset,limit);
        return repository.findAll(nextPage);
    }

    public Page<Book> getPageOfSearchResultBooks(String searchWord, Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset,limit);
        return repository.findBookByTitleContaining(searchWord,nextPage);
    }

    public Page<Book> getAllBooksByName(String searchWord, Integer offset, Integer limit) {
        Pageable nextPage = PageRequest.of(offset,limit);
        return repository.getAllBooksByName(searchWord,nextPage);
    }

    //--------------+

    public Page<Book> getPageOfNewestBooks(String from, String to,
                                           Integer offset, Integer limit) {

        Pageable nextPage = PageRequest.of(offset,limit);

        Date sqlFrom = Date.valueOf(from);
        Date sqlTo = Date.valueOf(to);

        if (sqlFrom.toLocalDate().isAfter(sqlTo.toLocalDate())) {

            return repository.getBooksByReleaseDateInReverseOrder(nextPage, sqlFrom, sqlTo);
        } else {

            return repository.getBooksByReleaseDateInNaturalOrder(nextPage, sqlFrom, sqlTo);
        }
    }
}