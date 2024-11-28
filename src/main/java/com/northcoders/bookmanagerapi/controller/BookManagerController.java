package com.northcoders.bookmanagerapi.controller;

import com.northcoders.bookmanagerapi.model.Book;
import com.northcoders.bookmanagerapi.model.Genre;
import com.northcoders.bookmanagerapi.service.BookManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/book")
public class BookManagerController {

    @Autowired
    BookManagerService bookManagerService;


    @GetMapping
    public ResponseEntity<Iterable<Book>> getBooks(@RequestParam(required = false) Genre genre) {
        Iterable<Book> books;
        if (genre != null) {
            books = bookManagerService.getBooksByGenre(genre);
        } else {
            books = bookManagerService.getAllBooks();
        }
        return ResponseEntity.ok(books);
    }


    @GetMapping("/{ID}")
    public ResponseEntity<Optional<Book>> getBookByID(@PathVariable("ID") Long ID){
        Optional<Book> book = bookManagerService.getBookByID(ID);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book newBook = bookManagerService.insertBook(book);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("book", "/api/v1/book/" + newBook.getId().toString());
        return new ResponseEntity<>(newBook, httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<Book> updateBook(@PathVariable Long bookId, @RequestBody Book bookDetails) throws Exception {
        Book updatedBook = bookManagerService.updateBook(bookId, bookDetails);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Book> deleteBookByID(@PathVariable("ID") Long ID){
        bookManagerService.deleteBook(ID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
