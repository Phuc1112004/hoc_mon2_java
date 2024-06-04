package com.example.bpro.controller;

import org.springframework.ui.Model;
import com.example.bpro.entity.Book;
import com.example.bpro.entity.Publisher;
import com.example.bpro.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/publishers")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping
    private String getAllPublishers(Model model){
        model.addAttribute("publishers", publisherService.getAllPublishers());
        return "publishers";
    }


    @GetMapping("/create")
    public String createBook(Model model) {
        model.addAttribute("publisher", new Book());
        return "add-publisher";
    }
    @PostMapping
    private String addBook(@ModelAttribute Publisher publisher) {
        publisherService.savePublisher(publisher);
        return "redirect:/publishers";
    }

    @GetMapping("/edit/{id}")
    private String editBook(@PathVariable Long id, Model model) {
        Publisher publisher = publisherService.getPublisherById(id);
        model.addAttribute("publisher", publisher);
        return "edit-publisher";
    }

    @PostMapping("/{id}")
    private String updatePublisher(@PathVariable Integer id,@ModelAttribute Publisher publisher) {
        publisher.setId(id);
        publisherService.savePublisher(publisher);
        return "redirect:/publishers";
    }

    @GetMapping("/delete/{id}")
    private String deletePublisher(@PathVariable Long id) {
        publisherService.deletePublisher(id);
        return "redirect:/publishers";
    }

    @GetMapping("/{id}")
    private String getPublisher(@PathVariable Long id, Model model) {
        Publisher publisher = publisherService.getPublisherById(id);
        model.addAttribute("publisher", publisher);
        return "publisher-details";
    }
}
