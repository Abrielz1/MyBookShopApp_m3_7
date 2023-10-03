package com.example.MyBookShopApp.entity.book.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Date;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "entity representing a book")
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("id generated by db automatically")
    private Long id;

    @Column(name = "pub_date") //дата публикации
    @ApiModelProperty("date of book publication")
    private Date pubDate;

    @Column(name = "is_bestseller")
    @ApiModelProperty("if isBestseller = 1 so the book is considered to be bestseller and if 0 the book is not a " +
            "bestseller")
    private Integer isBesteller;

    private String slug; // мнемонический идентификатор книги,
    // который будет отображаться в ссылке на его страницу

    private String title;

    private String image; //изображение обложки

    @Type(type = "org.hibernate.type.TextType")
    private String description; //описание книги

    @Column(name = "price_old") //цена в рублях основная
    @JsonProperty("price")
    private Integer priceOld;

    @Column(name = "discount")
    @JsonProperty("discount")
    private Double price; // скидка в процентах или 0, если её нет

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    @JsonIgnore
    @ToString.Exclude
    private Author author;
}
