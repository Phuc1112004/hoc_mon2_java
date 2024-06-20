package com.example.bookapi_v21.repository;


import com.example.bookapi_v21.model.BookPublisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookPublisherRepository extends JpaRepository<BookPublisher,Integer> {
}
