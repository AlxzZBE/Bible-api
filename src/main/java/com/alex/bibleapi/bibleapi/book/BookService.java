package com.alex.bibleapi.bibleapi.book;

import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book findByAbbrev(String abbrev) {
        return bookRepository.findByAbbrev(abbrev).orElseThrow(() -> new RuntimeException("Not Found Book"));
    }
}
