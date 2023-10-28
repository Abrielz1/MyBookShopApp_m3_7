package com.example.MyBookShopApp.service;

import com.example.MyBookShopApp.entity.book.entity.Book;
import com.example.MyBookShopApp.exceptions.ObjectNotFoundException;
import com.example.MyBookShopApp.repository.AuthorRepo;
import com.example.MyBookShopApp.repository.BookRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final AuthorRepo authorRepo;

    private final BookRepo repository;

    public List<Book> getBooksData() {
        return repository.findAll();
    }

    public List<Book> getBooksByAuthor(Long authorId) {

        authorRepo.findById(authorId).orElseThrow(() ->
                new ObjectNotFoundException("Author not found!"));

        return repository.getAllByAuthorId(authorId);
    }

    //NEW BOOK SERVICE METHODS

    public List<Book> getBooksByAuthor(String authorName){
        return repository.getBooksByAuthor(authorName);
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

    public List<Book> getPageOfRecommendedBooks(Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset,limit);
        List<Book> list = repository.getPageOfRecommendedBooks(nextPage).getContent();
                //repository.findAll(nextPage).getContent();

        return list;
    }

    public Page<Book> getPageOfSearchResultBooks(String searchWord, Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset,limit);
        return repository.findBookByTitleContaining(searchWord, nextPage);
    }

    public Page<Book> getAllBooksByName(String searchWord, Integer offset, Integer limit) {
        Pageable nextPage = PageRequest.of(offset,limit);
        return repository.getAllBooksByName(searchWord, nextPage);
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

    //TODO метод переделать
    public List<Book> getPageOfBooksByRating(Integer offset, Integer limit) {
        Pageable nextPage = PageRequest.of(offset,limit);

        return repository.getPageOfBooksByRating(nextPage);
    }
}