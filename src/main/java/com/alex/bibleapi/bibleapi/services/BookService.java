package com.alex.bibleapi.bibleapi.services;

import com.alex.bibleapi.bibleapi.domain.Book;
import com.alex.bibleapi.bibleapi.exceptions.NotFoundException;
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

    public Book findByAbbrevOrThrowNotFoundException(String abbrev) {
        return bookRepository.findByAbbrev(abbrev)
                .orElseThrow(() -> new NotFoundException("The Book with `abbrev` = `%s` Not Found.".formatted(abbrev)));
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public void save(BookPostRequestBody form) {
        Book newBook = form.newBook(form);
        bookRepository.save(newBook);
    }
}
