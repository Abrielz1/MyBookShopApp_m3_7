package com.example.MyBookShopApp.entity.book.entity;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@ApiModel(description = "data model for book entity")
@Getter
@Setter
@Entity
//@Builder(toBuilder = true)
//@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //    @Column(name = "author_id")
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "author_id", referencedColumnName = "id")
//    @ToString.Exclude
//    private Author author;

//    @ManyToMany
//    @JoinTable(name = "book2author",
//        joinColumns = @JoinColumn(name = "book_id"),
//        inverseJoinColumns = @JoinColumn(name = "author_id"))
//    private List<Author> list;
    //@ToString.Exclude
//(mappedBy = "books")
    @ManyToMany
    @JoinTable(name = "book2author",
    joinColumns =  {@JoinColumn(name = "book_id")},
    inverseJoinColumns = {@JoinColumn(name = "author_id")})
    private List<Author> list;

    private String title;

    @Column(name = "price_old")
    private Integer priceOld;

    private Integer price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.equals(priceOld, book.priceOld) && Objects.equals(price, book.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, priceOld, price);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", priceOld=" + priceOld +
                ", price=" + price +
                '}';
    }
}
