package com.northcoders.bookmanagerapi.service;

import com.northcoders.bookmanagerapi.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookManagerService {

    List<Book> getAllBooks();
    Book insertBook(Book book);
    Optional<Book> getBookByID(Long ID);
    public Book updateBook(Long id, Book bookDetails) throws Exception;
    public void deleteBook(Long ID);
}
