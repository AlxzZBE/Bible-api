package com.alex.bibleapi.bibleapi.verse;

import com.alex.bibleapi.bibleapi.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("verses")
public class VerseController {

    @Autowired
    private BookService bookService;
    @Autowired
    private VerseService verseService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestParam String abbrev, @RequestBody @Valid VersePostRequestBody form) {
        verseService.save(abbrev, form);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/{version}/{abbrev}/{chapter}/{number}")
    public ResponseEntity<Verse> findByVersionAbbrevChapterNumber(@PathVariable String version, @PathVariable String abbrev,
                                                                  @PathVariable Integer chapter, @PathVariable Integer number) {
        Verse verse = verseService.findByVersionAbbrevChapterNumber(version, abbrev, chapter, number)
                .orElseThrow(() -> new RuntimeException("Not Found Verse"));
        return ResponseEntity.ok(verse);
    }
}