package com.example.bookapi_v21.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "publisher")
    private Set<BookPublisher> bookPublishers;

    public Publisher() {
    }

    public Publisher(int id, String name, Set<BookPublisher> bookPublishers) {
        this.id = id;
        this.name = name;
        this.bookPublishers = bookPublishers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<BookPublisher> getBookPublishers() {
        return bookPublishers;
    }

    public void setBookPublishers(Set<BookPublisher> bookPublishers) {
        this.bookPublishers = bookPublishers;
    }
}
