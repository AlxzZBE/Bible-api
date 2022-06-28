package com.alex.bibleapi.bibleapi.services;

import com.alex.bibleapi.bibleapi.domain.Book;
import com.alex.bibleapi.bibleapi.exceptions.AlreadyExistsException;
import com.alex.bibleapi.bibleapi.exceptions.NotFoundException;
import com.alex.bibleapi.bibleapi.repositories.BookRepository;
import com.alex.bibleapi.bibleapi.requests.book.BookPostRequestBody;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void save(BookPostRequestBody form) {
        Optional<Book> possibleBook = bookRepository.findByAbbrev(form.getAbbrev());

        if (possibleBook.isEmpty()) {
            Book newBook = form.newBook(form);
            bookRepository.save(newBook);
        } else
            throw new AlreadyExistsException("Already Exists a Book with Abbrev: `%s`".formatted(form.getAbbrev()));
    }

    public Book findByAbbrevOrThrowNotFoundException(String abbrev) {
        return bookRepository.findByAbbrev(abbrev)
                .orElseThrow(() -> new NotFoundException("The Book with `abbrev` = `%s` Not Found.".formatted(abbrev)));
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }


}
