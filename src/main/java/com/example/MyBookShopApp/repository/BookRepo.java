package com.example.MyBookShopApp.repository;

import com.example.MyBookShopApp.entity.book.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.sql.Date;
import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

    @Query(value = """
           SELECT * FROM  public.books as b 
           join book2author b2a on b.id = b2a.book_id 
           join authors a on a.id = b2a.author_id WHERE a.id = ?
                   """, nativeQuery = true)
    List<Book> getAllByAuthorId(Long authorId);

 //   List<Book> findBooksByAuthor_FirstName(String name);

//    @Query("FROM Book")
//    List<Book> customFindAllBooks();

    //NEW BOOK REST REPOSITORY COMMANDS

    @Query(value = """
           SELECT * FROM public.books as b 
           join book2author b2a on b.id = b2a.book_id 
           join authors a on a.id = b2a.author_id 
           WHERE a.first_name like concat('%', ?, '%')
           """, nativeQuery = true)
    List<Book> getBooksByAuthor(String authorsFirstName);

    List<Book> findBooksByTitleContaining(String bookTitle);

    List<Book> findBooksByPriceOldBetween(Integer min, Integer max);

    List<Book> findBooksByPriceOldIs(Integer price);

    @Query("FROM Book WHERE isBestseller = 1")
    List<Book> getBestsellers();


    @Query(value = "SELECT * FROM books WHERE discount = (SELECT MAX(discount) FROM books)", nativeQuery = true)
    List<Book> getBooksWithMaxDiscount();

    Page<Book> findBookByTitleContaining(String bookTitle, Pageable nextPage);

    @Query(value = "select * from public.books where books.title like concat('%', ?, '%')", nativeQuery = true)
    Page<Book> getAllBooksByName(String title, Pageable nextPage);

    //-----------

    @Query(value = "SELECT * FROM public.books " +
                   "WHERE books.pub_date " +
                   "BETWEEN ?1 AND ?2 ORDER BY books.pub_date DESC", nativeQuery = true)
    Page<Book> getBooksByReleaseDateInReverseOrder(Pageable nextPage, Date date1, Date date2);

    @Query(value = "SELECT * FROM public.books " +
                   "WHERE books.pub_date BETWEEN ?1 AND ?2 " +
                   "ORDER BY books.pub_date ASC ", nativeQuery = true)
    Page<Book> getBooksByReleaseDateInNaturalOrder(Pageable nextPage, Date date1, Date date2);


    //-----+

    @Query(value = """
           SELECT * FROM public.books as b 
           join book2author b2a on b.id = b2a.book_id 
           join authors a on a.id = b2a.author_id
           """, nativeQuery = true)
    Page<Book> getPageOfRecommendedBooks(Pageable nextPage);
}
