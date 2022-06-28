package com.alex.bibleapi.bibleapi.controllers;

import com.alex.bibleapi.bibleapi.requests.book.BookGet;
import com.alex.bibleapi.bibleapi.requests.book.BookPostRequestBody;
import com.alex.bibleapi.bibleapi.services.BookService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public void save(@RequestBody @Valid BookPostRequestBody form) {
        bookService.save(form);
    }

    @GetMapping
    public List<BookGet> findAllBooks() {
        return bookService.findAll().stream().map(BookGet::new)
                .toList();
    }
}
