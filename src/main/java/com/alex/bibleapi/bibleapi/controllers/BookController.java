package com.alex.bibleapi.bibleapi.controllers;

import com.alex.bibleapi.bibleapi.domain.Book;
import com.alex.bibleapi.bibleapi.requests.book.BookGet;
import com.alex.bibleapi.bibleapi.requests.book.BookPostRequestBody;
import com.alex.bibleapi.bibleapi.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Void> saveOneBook(@RequestBody @Valid BookPostRequestBody form) {
        bookService.save(form);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().queryParam("abbrev", form.getAbbrev())
                .buildAndExpand().toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<BookGet> findByAbbrev(@RequestParam String abbrev) {
        Book savedBook = bookService.findByAbbrevOrThrowNotFoundException(abbrev);
        return ResponseEntity.ok(new BookGet(savedBook));
    }

//    @GetMapping
//    public List<BookGet> findAllBooks() {
//        return bookService.findAll().stream().map(BookGet::new)
//                .toList();
//    }
}
