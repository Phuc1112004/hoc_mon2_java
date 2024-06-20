package com.example.bookapi_v21.controller;

import com.example.bookapi_v21.model.Publisher;
import com.example.bookapi_v21.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v2.1/publisher")
public class PublisherController {
    @Autowired
    private PublisherService publisherService;
}
