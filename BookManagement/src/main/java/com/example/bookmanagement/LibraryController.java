package com.example.bookmanagement;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.nio.file.OpenOption;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/libraries")
public class LibraryController {
//    call instance of model
    private final LibraryRepository libraryRepository;
    private final BookRepository bookRepository;

    @Autowired
    public LibraryController(LibraryRepository libraryRepository, BookRepository bookRepository) {
        this.libraryRepository = libraryRepository;
        this.bookRepository = bookRepository;
    }
    @PostMapping("/")
    public ResponseEntity<Library> create(@Valid @RequestBody Library library) {
        Library savedLibrary = libraryRepository.save(library);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedLibrary.getId()).toUri();

        return ResponseEntity.created(location).body(savedLibrary);

    }


    @GetMapping("/")
    public ResponseEntity<Page<Library>>GetAll(Pageable pageable) {
        return ResponseEntity.ok(libraryRepository.findAll(pageable));
    }

    @PutMapping  //edit
    public ResponseEntity<Library> update(@PathVariable Integer id,@Valid @RequestBody Library library){
        Optional<Library> optionLibrary = libraryRepository.findById(id);
        if(!optionLibrary.isPresent()){
            return ResponseEntity.notFound().build();
        }

        library.setId(optionLibrary.get().getId());
        libraryRepository.save(library);
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Library> delete(@PathVariable Integer id) {
        Optional<Library> optionLibrary = libraryRepository.findById(id);
        if(!optionLibrary.isPresent()){   // !
            return ResponseEntity.unprocessableEntity().build();
        }
        deleteLibraryTransaction(optionLibrary.get());
        return ResponseEntity.noContent().build();
    }

    @Transactional //  đảm bảo tính toàn vẹn của giao dịch ACID
    public void deleteLibraryTransaction(Library library){
        bookRepository.deleteByLibraryId(library.getId());
        libraryRepository.delete(library);
    }

    @GetMapping("/{id}")
    ResponseEntity<Library> getById(@PathVariable Integer id) {
        Optional<Library> optionLibrary = libraryRepository.findById(id);
        if(!optionLibrary.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(optionLibrary.get());
    }
}
