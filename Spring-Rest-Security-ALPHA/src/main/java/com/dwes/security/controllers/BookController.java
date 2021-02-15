package com.dwes.security.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.dwes.security.entities.Book;
import com.dwes.security.error.BookNotFoundException;
import com.dwes.security.repos.BookRepository;


import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@Validated
@RestController
public class BookController {

    @Autowired
    private BookRepository repository;

    /**
    // Get all
    @GetMapping("/books")
    List<Book> findAll() {
        return repository.findAll();
    }
    */
    @GetMapping("/books")
    public ResponseEntity<?> getBooks(){
    	List<Book> resutl = repository.findAll();
    	
    	if(resutl.isEmpty()) {
    		return ResponseEntity.notFound().build();
    	}else {
    		return ResponseEntity.ok(resutl);
    	}
    	
    }


/**
    // Save
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/books")
    Book newBook(@Valid @RequestBody Book newBook) {
        return repository.save(newBook);
    }*/
    @PostMapping("/books")
    public ResponseEntity<Book> newBook(@Valid @RequestBody Book newBook) {
    	Book saved = repository.save(newBook);
    	return ResponseEntity.status(HttpStatus.CREATED).body(saved); //->201
    }
    
/**
    // Find
    @GetMapping("/books/{id}")
    Book findOne(@PathVariable @Min(1) Long id) { //jsr 303 annotations
        return repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }*/
    
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> findOne(@PathVariable @Min(1) Long id) { //jsr 303 annotations
    	Book book = repository.findById(id).orElse(null);
    	if(book == null) {
    		return ResponseEntity.noContent().build(); //-->204
    	}else {
    		return ResponseEntity.ok(book); //-->200
    	}
    }
/**
    // Save or update
    @PutMapping("/books/{id}")
    Book saveOrUpdate(@RequestBody Book newBook, @PathVariable Long id) {

        return repository.findById(id)
                .map(x -> {
                    x.setName(newBook.getName());
                    x.setAuthor(newBook.getAuthor());
                    x.setPrice(newBook.getPrice());
                    return repository.save(x);
                })
                .orElseGet(() -> {
                    newBook.setId(id);
                    return repository.save(newBook);
                });
    }*/
    
    @PutMapping("/books/{id}")
    public ResponseEntity<Book> saveOrUpdate( @RequestBody Book newBook, @PathVariable Long id) {

        return repository.findById(id)
                .map(p -> {
                    p.setName(newBook.getName());
                    p.setAuthor(newBook.getAuthor());
                    p.setPrice(newBook.getPrice());
                    return ResponseEntity.ok(repository.save(p));
                })
                .orElseGet(() -> {
                   // return ResponseEntity.notFound().build();
                    throw new BookNotFoundException(id);
                });
    }
    
/**
    // update author only
    @PatchMapping("/books/{id}")
    Book patch(@RequestBody Map<String, String> update, @PathVariable Long id) {

        return repository.findById(id)
                .map(x -> {

                    String author = update.get("author");
                    if (!StringUtils.isEmpty(author)) {
                        x.setAuthor(author);

                        // better create a custom method to update a value = :newValue where id = :id
                        return repository.save(x);
                    } else {
                        throw new BookUnSupportedFieldPatchException(update.keySet());
                    }

                })
                .orElseGet(() -> {
                    throw new BookNotFoundException(id);
                });
    }
*/
    

    /**
   
    @DeleteMapping("/books/{id}")
    void deleteBook(@PathVariable Long id) {
        repository.deleteById(id);
    } */
    

    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

