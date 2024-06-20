package com.example.bookapi_v21.controller;


import com.example.bookapi_v21.model.Book;
import com.example.bookapi_v21.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v2.1/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {return bookService.getAllBooks();}

    @PostMapping
    public Book createBook(@RequestBody Book book){
        return bookService.createBook(book);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id){
        Optional<Book> book = bookService.getBookById(id);
        if (book.isPresent()){
            return ResponseEntity.ok(book.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id,@RequestBody Book book){
        Optional<Book> optionalBook = bookService.getBookById(id);
        if (optionalBook.isPresent()){
            Book newBook = optionalBook.get();
            newBook.setName(book.getName());
            Book bookUpdate = bookService.updateBook(id,newBook);

            return ResponseEntity.ok(bookUpdate);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable int id){
        Optional<Book> optionalBook = bookService.getBookById(id);
        if (optionalBook.isPresent()){
            bookService.deleteBook(id);

            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
