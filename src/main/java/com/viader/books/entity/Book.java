package com.viader.books.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Table(name="BOOK")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="TITLE")
    @NotNull
    private String title;

    @Column(name="AUTHOR")
    @NotNull
    private String author;

    @Column(name="ISBN")
    @NotNull
    private String isbn;

    @Column(name="BORROWED")
    private boolean borrowed;

    @Column(name="BORROWER")
    private String borrower;
}
