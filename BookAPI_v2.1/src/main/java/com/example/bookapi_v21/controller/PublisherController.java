package com.example.bookapi_v21.controller;


import com.example.bookapi_v21.model.Book;
import com.example.bookapi_v21.model.Publisher;
import com.example.bookapi_v21.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v2.1/publisher")
public class PublisherController {
    @Autowired
    private PublisherService publisherService;

    @GetMapping
    public List<Publisher> getAllPublishers(){
        return publisherService.getAllPublishers();
    }

    @PostMapping
    public Publisher createPublisher(@RequestBody Publisher publisher){
        return publisherService.createPublisher(publisher);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publisher> getPublisherById(@PathVariable int id){
        Optional<Publisher> publisher = publisherService.getPublisherById(id);
        if(publisher.isPresent()){
            return ResponseEntity.ok(publisher.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Publisher> updatePublisher(@PathVariable int id, @RequestBody Publisher publisher){
        Optional<Publisher> optionalPublisher = publisherService.getPublisherById(id);
        if(optionalPublisher.isPresent()){
            Publisher newPublisher = optionalPublisher.get();
            newPublisher.setName(publisher.getName());
            Publisher publisherUpdate = publisherService.updatePublisher(id, newPublisher);

            return ResponseEntity.ok(publisherUpdate);
        }else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Publisher> deletePublisher(@PathVariable int id){
        Optional<Publisher> optionalPublisher = publisherService.getPublisherById(id);
        if(optionalPublisher.isPresent()){
            publisherService.deletePublisher(id);

            return ResponseEntity.ok(optionalPublisher.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}
