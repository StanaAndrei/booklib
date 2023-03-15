package com.booklib.service;

import java.util.List;

import com.booklib.model.Book;
import com.booklib.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooksSortedByAuthorAndTitle() {
        return bookRepository.findAll();
    }

    @Override
    public void deleteBook(String title) {
        bookRepository.deleteByTitle(title);
    }

    @Override
    public List<Book> searchBooksByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Override
    public void updateAuthor(String title, String author) {
        bookRepository.updateAuthorByTitle(title, author);
    }
}
