package com.booklib.repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.booklib.model.Book;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryBookRepository implements BookRepository {

    private List<Book> books = new ArrayList<>();

    @Override
    public Book save(Book book) {
        books.add(book);
        return book;
    }

    @Override
    public List<Book> findAll() {
        Comparator<Book> byAuthorThenTitle = Comparator.comparing(Book::getAuthor).thenComparing(Book::getTitle);
        return books.stream().sorted(byAuthorThenTitle).collect(Collectors.toList());
    }

    @Override
    public void deleteByTitle(String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }

    @Override
    public List<Book> findByTitle(String title) {
        return books.stream().filter(book -> book.getTitle().equalsIgnoreCase(title)).collect(Collectors.toList());
    }

    @Override
    public void updateAuthorByTitle(String title, String author) {
        books.stream().filter(book -> book.getTitle().equalsIgnoreCase(title)).forEach(book -> book.setAuthor(author));
    }
}
