package com.booklib.service;

import com.booklib.model.Book;

import java.util.List;

public interface LibraryService {
    Book addBook(Book book);
    List<Book> getAllBooksSortedByAuthorAndTitle();
    void deleteBook(String title);
    List<Book> searchBooksByTitle(String title);
    void updateAuthor(String title, String author);
}
