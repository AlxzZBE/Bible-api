package com.alex.bibleapi.bibleapi.util;

import com.alex.bibleapi.bibleapi.domain.Book;

public class BookCreator {

    public static final int ID = 2;
    public static final String AUTHOR = "Moisés";
    public static final String NAME = "Gênesis";
    public static final String ABBREV = "gn";
    public static final String LANGUAGE = "pt";
    public static final Integer CHAPTERS = 50;
    public static final Integer TESTAMENT = 0;
    public static final String DESCRIPTION = "DESC";

    public static Book createValidBook() {
        return new Book(ID, AUTHOR, NAME, ABBREV, LANGUAGE, CHAPTERS, TESTAMENT, DESCRIPTION);
    }

    public static Book createBookToBeSaved() {
        return new Book(null, AUTHOR, NAME, ABBREV, LANGUAGE, CHAPTERS, TESTAMENT, DESCRIPTION);
    }
}