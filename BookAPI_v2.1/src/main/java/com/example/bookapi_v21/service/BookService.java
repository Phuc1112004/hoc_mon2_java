package com.example.bookapi_v21.service;


import com.example.bookapi_v21.model.Book;
import com.example.bookapi_v21.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //implement interface jpa and biz code
public class BookService {
    //DI
    @Autowired
    private BookRepository bookRepositoty;

    public List<Book> getAllBooks() {
        return bookRepositoty.findAll();
    }

    public Book createBook(Book book) {
        return bookRepositoty.save(book);
    }

    public Optional<Book> getBookById(int id){
        return bookRepositoty.findById(id);
    }

    public void deleteBook(int id){
        bookRepositoty.deleteById(id);
    }

    public Book updateBook(int id,Book book){
        if (bookRepositoty.existsById(id)){
            book.setId(id);
            return bookRepositoty.save(book);
        }else{
            throw new IllegalArgumentException("Book not found");
        }
    }


}

