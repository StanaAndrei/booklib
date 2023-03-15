package com.booklib.repository;

import com.booklib.model.Book;

import java.util.List;

public interface BookRepository {
    Book save(Book book);
    List<Book> findAll();
    void deleteByTitle(String title);
    List<Book> findByTitle(String title);
    void updateAuthorByTitle(String title, String author);
}
