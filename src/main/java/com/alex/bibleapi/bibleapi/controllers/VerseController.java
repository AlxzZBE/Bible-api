package com.alex.bibleapi.bibleapi.controllers;

import com.alex.bibleapi.bibleapi.domain.Verse;
import com.alex.bibleapi.bibleapi.temp.ArrayVersePostRequestBody;
import com.alex.bibleapi.bibleapi.requests.verse.ListVerseGet;
import com.alex.bibleapi.bibleapi.requests.verse.VerseGet;
import com.alex.bibleapi.bibleapi.requests.verse.VersePostRequestBody;
import com.alex.bibleapi.bibleapi.services.BookService;
import com.alex.bibleapi.bibleapi.services.VerseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("verses")
public class VerseController {

    private final BookService bookService;
    private final VerseService verseService;

    public VerseController(BookService bookService, VerseService verseService) {
        this.bookService = bookService;
        this.verseService = verseService;
    }

    @PostMapping
    public ResponseEntity<Void> saveOneVerse(@RequestParam String abbrev, @RequestBody @Valid VersePostRequestBody form) {
        verseService.save(abbrev, form);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("verses/{version}/{abbrev}/{chapter}/{number}")
                .buildAndExpand(form.getVersion(), abbrev, form.getChapter(), form.getNumber()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PostMapping(path = "/all")
    public ResponseEntity<Void> saveVersesByChapter(@RequestParam String abbrev,
                                                    @RequestBody @Valid ArrayVersePostRequestBody form) {
        verseService.saveVersesByChapter(abbrev, form);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/verses/{version}/{abbrev}/{chapter}")
                .buildAndExpand(form.getVersion(), abbrev, form.getChapter()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(path = "/{version}/{abbrev}/{chapter}/{number}")
    public ResponseEntity<VerseGet> findByVersionAbbrevChapterNumber(@PathVariable String version, @PathVariable String abbrev,
                                                                     @PathVariable Integer chapter, @PathVariable Integer number) {
        Verse verse = verseService.findByVersionAbbrevChapterNumber(version, abbrev, chapter, number)
                .orElseThrow(() -> new RuntimeException("Not Found Verse"));
        return ResponseEntity.ok(new VerseGet(verse));
    }

    @GetMapping(path = "/{version}/{abbrev}/{chapter}")
    public ResponseEntity<ListVerseGet> findByVersionAbbrevChapter(@PathVariable String version, @PathVariable String abbrev,
                                                                   @PathVariable Integer chapter) {
        return ResponseEntity.ok(new ListVerseGet(verseService.findByVersionAbbrevChapter(version, abbrev, chapter)));

    }
}