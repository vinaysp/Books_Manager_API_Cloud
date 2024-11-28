package com.northcoders.bookmanagerapi.service;

import com.northcoders.bookmanagerapi.model.Book;
import com.northcoders.bookmanagerapi.repository.BookManagerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookManagerServiceImpl implements BookManagerService {

    @Autowired
    BookManagerRepository bookManagerRepository;

    @Override
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        bookManagerRepository.findAll().forEach(books::add);
        return books;
    }

    @Override
    public Optional<Book> getBookByID(Long ID){
        return bookManagerRepository.findById(ID);
    }

    @Override
    public Book insertBook(Book book) {
        return bookManagerRepository.save(book);
    }


}
