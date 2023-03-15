package com.booklib.controller;

import java.util.List;

import com.booklib.model.Book;
import com.booklib.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library/books")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return libraryService.addBook(book);
    }

    @GetMapping
    public List<Book> getAllBooksSortedByAuthorAndTitle() {
        return libraryService.getAllBooksSortedByAuthorAndTitle();
    }

    @DeleteMapping("/{title}")
    public void deleteBook(@PathVariable("title") String title) {
        libraryService.deleteBook(title);
    }

    @PatchMapping("/{title}")
    public void updateBookByTitle(@PathVariable("title") String title, @RequestParam String author) {
        libraryService.updateAuthor(title, author);
    }

    @GetMapping("/{title}")
    public List<Book> searchBooksByTitle(@PathVariable("title") String title) {
        return libraryService.searchBooksByTitle(title);
    }
}