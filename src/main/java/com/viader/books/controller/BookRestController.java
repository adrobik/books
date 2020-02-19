package com.viader.books.controller;

import com.viader.books.entity.Book;
import com.viader.books.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class BookRestController {

    @Autowired
    private BookService bookService;

//    public void setBookService(BookService bookService){
//        this.bookService = bookService;
//    }

    @GetMapping("/api/books")
    public List<Book> getBooks() {
        List<Book> books = bookService.retrieveBooks();
        return books;
    }

    @GetMapping("/api/books/{bookId}")
    public Book getBook(@PathVariable(name="bookId")Long bookId) {
        return bookService.getBook(bookId);
    }

    @PostMapping("/api/books")
    public void saveBook(Book book) {
        bookService.saveBook(book);
        log.info("Book: {} saved successfully", book.getTitle());
    }

    @DeleteMapping("/api/books/{bookId}")
    public void deleteBook(@PathVariable(name="bookId")Long bookId){
        bookService.deleteBook(bookId);
        log.info("Book: {} deleted successfully", bookId);
    }

    @PutMapping("/api/books/{bookId}")
    public void updateBook(@RequestBody Book book, @PathVariable(name="bookId")Long bookId) {
        Book bo = bookService.getBook(bookId);
        if(bo != null){
            bookService.updateBook(book);
        }
    }

}
