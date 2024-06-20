package com.example.bookmanagement;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    private final BookRepository bookRepository;
    private final LibraryRepository libraryRepository;

    public BookController(BookRepository bookRepository, LibraryRepository libraryRepository) {
        this.bookRepository = bookRepository;
        this.libraryRepository = libraryRepository;
    }
    @GetMapping
    public ResponseEntity<Page<Book>> getAllBooks(Pageable pageable) {
        return ResponseEntity.ok(bookRepository.findAll(pageable));
    }


//    create book
    @PostMapping
    public ResponseEntity<Book> create(@RequestBody @Valid Book book){
        Optional<Library> optionalLibrary = libraryRepository.findById((book.getLibrary().getId()));
        if(!optionalLibrary.isPresent()){
            return ResponseEntity.badRequest().build();
        }
        book.setLibrary(optionalLibrary.get());
        Book saveBook = bookRepository.save(book);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(saveBook.getId()).toUri();

        return ResponseEntity.created(location).body(saveBook);
    }


}
