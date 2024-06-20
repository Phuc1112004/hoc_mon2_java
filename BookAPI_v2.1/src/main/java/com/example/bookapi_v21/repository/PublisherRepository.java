package com.example.bookapi_v21.repository;


import com.example.bookapi_v21.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher,Integer> {
}
