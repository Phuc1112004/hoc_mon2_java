package com.example.bookapi_v21.service;

import com.example.bookapi_v21.model.Book;
import com.example.bookapi_v21.model.Publisher;
import com.example.bookapi_v21.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;

    public List<Publisher> getAllPublishers(){
        return publisherRepository.findAll();
    }

    public Publisher createPublisher(Publisher publisher){
        return publisherRepository.save(publisher);
    }

    public Publisher getPublisherById(int id){
        return publisherRepository.findById(id).get();
    }

    public void deletePublisher(int id){
        publisherRepository.deleteById(id);
    }

    public Publisher updatePublisher(int id,Publisher publisher){
        if (publisherRepository.existsById(id)){
            publisher.setId(id);
            return publisherRepository.save(publisher);
        }else {
            throw new IllegalArgumentException("Publisher not found");
        }
    }
}
