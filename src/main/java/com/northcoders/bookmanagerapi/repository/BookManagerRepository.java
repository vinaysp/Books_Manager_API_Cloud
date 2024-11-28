package com.northcoders.bookmanagerapi.repository;

import com.northcoders.bookmanagerapi.model.Book;
import com.northcoders.bookmanagerapi.model.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookManagerRepository extends CrudRepository<Book, Long> {

    Iterable<Book> findByGenre(Genre genre);
}
