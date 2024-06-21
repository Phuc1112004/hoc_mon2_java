package com.example.bookapi_v21.controller;

import com.example.bookapi_v21.model.BookPublisher;
import com.example.bookapi_v21.repository.BookPublisherRepository;
import com.example.bookapi_v21.service.BookPublisherService;
import com.example.bookapi_v21.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v2.1/details")
public class BookPublisherController {
    private BookPublisherService bookPublisherService;

    @GetMapping
    public List<BookPublisher> getAllBookPublisher() {
        return bookPublisherService.getAllBookPublishers();
    }

    @PostMapping
    public BookPublisher createBookPublisher(@RequestBody BookPublisher bookPublisher) {
        return bookPublisherService.createBookPublisher(bookPublisher);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookPublisher> getBookPublisherById(@PathVariable int id) {
        Optional<BookPublisher> bookPublisher = bookPublisherService.getBookPublisherById(id);
        if (bookPublisher.isPresent()) {
            return ResponseEntity.ok(bookPublisher.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookPublisher> updateBookPublisher(@PathVariable int id, @RequestBody BookPublisher bookPublisher) {
        Optional<BookPublisher> optionalBookPublisher = bookPublisherService.getBookPublisherById(id);
        if (optionalBookPublisher.isPresent()) {
            BookPublisher newBookPublisher = optionalBookPublisher.get();
            newBookPublisher.setBook(bookPublisher.getBook());
            newBookPublisher.setPublisher(bookPublisher.getPublisher());
            newBookPublisher.setPublishedDate(bookPublisher.getPublishedDate());

            return ResponseEntity.ok(newBookPublisher);

        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<BookPublisher> deleteBookPublisher(@PathVariable int id) {
        Optional<BookPublisher> optionalBookPublisher = bookPublisherService.getBookPublisherById(id);
        if (optionalBookPublisher.isPresent()) {
            BookPublisherService.deleteBookPublisher(id);
            return ResponseEntity.ok(optionalBookPublisher.get());
        }
        return ResponseEntity.notFound().build();
    }


}
