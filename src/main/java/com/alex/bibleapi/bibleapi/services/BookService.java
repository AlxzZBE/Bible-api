package com.alex.bibleapi.bibleapi.services;

import com.alex.bibleapi.bibleapi.domain.Book;
import com.alex.bibleapi.bibleapi.repositories.BookRepository;
import com.alex.bibleapi.bibleapi.requests.book.BookPostRequestBody;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book findByAbbrev(String abbrev) {
        return bookRepository.findByAbbrev(abbrev).orElseThrow(() -> new RuntimeException("Not Found Book"));
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public void save(BookPostRequestBody form) {
        Book newBook = form.newBook(form);
        bookRepository.save(newBook);
    }
}
