package com.alex.bibleapi.bibleapi.verse;

import com.alex.bibleapi.bibleapi.book.Book;
import com.alex.bibleapi.bibleapi.book.BookService;
import org.springframework.stereotype.Service;

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
        Book book = bookService.findByAbbrev(abbrev);
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
        Book book = bookService.findByAbbrev(abbrev);
        return verseRepository.findByVersionAndChapterAndNumberAndBook_id(version, chapter, number, book.getId());
    }
}
