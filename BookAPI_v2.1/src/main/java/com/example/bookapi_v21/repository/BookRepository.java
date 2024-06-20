package com.example.bookapi_v21.repository;

import com.example.bookapi_v21.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
