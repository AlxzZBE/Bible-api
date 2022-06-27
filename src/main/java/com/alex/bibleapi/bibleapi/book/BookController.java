package com.alex.bibleapi.bibleapi.book;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping
    public void save(@RequestBody @Valid BookPostRequestBody form) {
        Book newBook = form.newBook(form);
        System.out.println("Saving: " + form);
        bookRepository.save(newBook);
    }

    @GetMapping
    public List<Book> findBooks() {
        return bookRepository.findAll();
    }
}
