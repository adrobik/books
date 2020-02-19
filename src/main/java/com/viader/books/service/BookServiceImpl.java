package com.viader.books.service;

import com.viader.books.entity.Book;
import com.viader.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> retrieveBooks() {
        List<Book> books = bookRepository.findAll();
        return books;
    }

    @Override
    public Book getBook(Long bookId) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        return optionalBook.get();
    }

    @Override
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public void updateBook(Book book) {
        bookRepository.save(book);
    }
}
