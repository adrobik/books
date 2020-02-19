package com.viader.books.service;

import com.viader.books.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> retrieveBooks();
    Book getBook(Long bookId);
    void saveBook(Book book);
    void deleteBook(Long bookId);
    void updateBook(Book book);
}
