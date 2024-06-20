package com.example.bookmanagement;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String name;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)     // lazy: lay mot phan danh sach ra;   eager: lay toan bo du lieu
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Library library;


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

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}
