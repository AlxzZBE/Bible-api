package com.alex.bibleapi.bibleapi.controllers;

import com.alex.bibleapi.bibleapi.domain.Verse;
import com.alex.bibleapi.bibleapi.requests.verse.ListVerseGet;
import com.alex.bibleapi.bibleapi.requests.verse.VerseGet;
import com.alex.bibleapi.bibleapi.requests.verse.VersePostRequestBody;
import com.alex.bibleapi.bibleapi.services.VerseService;
import com.alex.bibleapi.bibleapi.temp.ArrayVersePostRequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("verses")
public class VerseController {

    private final VerseService verseService;

    public VerseController(VerseService verseService) {
        this.verseService = verseService;
    }

    @PostMapping(params = "abbrev")
    public ResponseEntity<Void> saveOneVerse(@RequestParam String abbrev, @RequestBody @Valid VersePostRequestBody form) {
        verseService.saveOneVerse(abbrev, form);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("verses/{version}/{abbrev}/{chapter}/{number}")
                .buildAndExpand(form.getVersion(), abbrev, form.getChapter(), form.getNumber()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PostMapping(path = "/all", params = "abbrev")
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
        Verse verse = verseService.findByVersionAbbrevChapterNumber(version, abbrev, chapter, number);
        return ResponseEntity.ok(new VerseGet(verse));
    }

    @GetMapping(path = "/{version}/{abbrev}/{chapter}")
    public ResponseEntity<ListVerseGet> findByVersionAbbrevChapter(@PathVariable String version, @PathVariable String abbrev,
                                                                   @PathVariable Integer chapter) {
        return ResponseEntity.ok(new ListVerseGet(verseService.findAllByVersionAbbrevChapter(version, abbrev, chapter)));
    }
}