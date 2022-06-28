package com.alex.bibleapi.bibleapi.services;

import com.alex.bibleapi.bibleapi.domain.Book;
import com.alex.bibleapi.bibleapi.domain.Verse;
import com.alex.bibleapi.bibleapi.exceptions.AlreadyExistsException;
import com.alex.bibleapi.bibleapi.repositories.VerseRepository;
import com.alex.bibleapi.bibleapi.requests.verse.VersePostRequestBody;
import com.alex.bibleapi.bibleapi.temp.ArrayVersePostRequestBody;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VerseService {

    private final VerseRepository verseRepository;
    private final BookService bookService;

    public VerseService(VerseRepository verseRepository, BookService bookService) {
        this.verseRepository = verseRepository;
        this.bookService = bookService;
    }

    public void save(String abbrev, VersePostRequestBody form) {
        Book book = bookService.findByAbbrevOrThrowNotFoundException(abbrev);

        Optional<Verse> possibleVerse = verseRepository.findByVersionAndChapterAndNumberAndBook_id(
                form.getVersion(), form.getChapter(), form.getNumber(), book.getId());

        if (possibleVerse.isEmpty()) {
            Verse newVerse = form.newVerse(form, book);
            verseRepository.save(newVerse);
        } else
            throw new AlreadyExistsException(
                    "Already Exists a Verse in the Book: `%s` Chapter: `%d` Number: `%d` Version: `%s`"
                            .formatted(book.getName(), form.getChapter(), form.getNumber(), form.getVersion()));
    }

    public void saveVersesByChapter(String abbrev, ArrayVersePostRequestBody form) {
        Book book = bookService.findByAbbrevOrThrowNotFoundException(abbrev);

        List<Verse> possibleVerses = verseRepository
                .findByVersionAndBook_idAndChapter(form.getVersion(), book.getId(), form.getChapter());

        if (possibleVerses.isEmpty()) {
            List<Verse> verses = form.newVerses(form, book);
            verseRepository.saveAll(verses);
        } else
            throw new AlreadyExistsException(
                    "Already Exists some Verses in the Book: `%s` Chapter: `%d` Version: `%s`"
                            .formatted(book.getName(), form.getChapter(), form.getVersion()));
    }

    public Optional<Verse> findByVersionAbbrevChapterNumber(String version, String abbrev, Integer chapter, Integer
            number) {
        Book book = bookService.findByAbbrevOrThrowNotFoundException(abbrev);
        return verseRepository.findByVersionAndChapterAndNumberAndBook_id(version, chapter, number, book.getId());
    }

    public List<Verse> findByVersionAbbrevChapter(String version, String abbrev, Integer chapter) {
        Book book = bookService.findByAbbrevOrThrowNotFoundException(abbrev);
        return verseRepository.findByVersionAndBook_idAndChapter(version, book.getId(), chapter);
    }


}