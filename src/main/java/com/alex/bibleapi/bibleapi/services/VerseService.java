package com.alex.bibleapi.bibleapi.services;

import com.alex.bibleapi.bibleapi.domain.Book;
import com.alex.bibleapi.bibleapi.domain.Verse;
import com.alex.bibleapi.bibleapi.repositories.VerseRepository;
import com.alex.bibleapi.bibleapi.temp.ArrayVersePostRequestBody;
import com.alex.bibleapi.bibleapi.requests.verse.VersePostRequestBody;
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
        Verse newVerse = form.newVerse(form, book);

        Optional<Verse> possibleVerse = findByVersionAbbrevChapterNumber(
                form.getVersion(), abbrev, form.getChapter(), form.getNumber());

        if (possibleVerse.isEmpty())
            verseRepository.save(newVerse);
        else
            throw new RuntimeException("Already exists a verse in this book");
    }

    public Optional<Verse> findByVersionAbbrevChapterNumber(String version, String abbrev, Integer chapter, Integer
            number) {
        Book book = bookService.findByAbbrevOrThrowNotFoundException(abbrev);
        return verseRepository.findByVersionAndChapterAndNumberAndBook_id(version, chapter, number, book.getId());
    }

    public List<Verse> findByVersionAbbrevChapter(String version, String abbrev, Integer chapter) {
        Book book = bookService.findByAbbrevOrThrowNotFoundException(abbrev);
        return verseRepository.findByVersionAndChapterAndBook_id(version, chapter, book.getId());
    }

    public void saveVersesByChapter(String abbrev, ArrayVersePostRequestBody form) {
        Book book = bookService.findByAbbrevOrThrowNotFoundException(abbrev);
        List<Verse> verses = form.newVerses(form, book);
        verseRepository.saveAll(verses);
    }
}