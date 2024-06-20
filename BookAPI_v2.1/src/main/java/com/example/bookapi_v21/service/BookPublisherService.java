package com.example.bookapi_v21.service;

import com.example.bookapi_v21.model.BookPublisher;
import com.example.bookapi_v21.repository.BookPublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookPublisherService {
    @Autowired
    private BookPublisherRepository bookPublisherRepository;

    public List<BookPublisher> getAllBookPublishers() {
        return bookPublisherRepository.findAll();
    }

    public BookPublisher createBookPublisher(BookPublisher bookPublisher) {
        return bookPublisherRepository.save(bookPublisher);
    }

    public Optional<BookPublisher> getBookPublisherById(int id) {
        return bookPublisherRepository.findById(id);
    }

    public void deleteBookPublisher(int id) {
        bookPublisherRepository.deleteById(id);
    }

    public BookPublisher updateBookPublisher(int id, BookPublisher bookPublisher) {
        if (bookPublisherRepository.existsById(id)){
            bookPublisher.setId(id);
            return bookPublisherRepository.save(bookPublisher);
        }else{
            throw new IllegalArgumentException("BookPublisher not found");
        }
    }

}
