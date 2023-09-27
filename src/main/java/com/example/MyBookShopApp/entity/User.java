package com.example.MyBookShopApp.entity;

import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.Email;
import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Data
@Builder(toBuilder = true)
public class User {

    @PositiveOrZero
    private Long id;

    @NotBlank
    @Column(name = "user_name")
    private String userName;

    @NotBlank(message = "Отсутствует телефон")
    @Column(name = "phone")
    private String phone;

    @NotBlank(message = "Отсутствует email")
    @Email(message = "Некорректный email")
    private String email;

    private Boolean isApproved;
}
