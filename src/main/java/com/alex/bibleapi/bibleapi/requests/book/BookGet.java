package com.alex.bibleapi.bibleapi.requests.book;

import com.alex.bibleapi.bibleapi.domain.Book;

public class BookGet {

    private String author;
    private String name;
    private String abbrev;
    private String language;
    private Integer chapters;
    private String testament;
    private String description;

    public BookGet(Book form) {
        this.author = form.getAuthor();
        this.name = form.getName();
        this.abbrev = form.getAbbrev();
        this.language = form.getLanguage();
        this.chapters = form.getChapters();
        this.testament = convertTestament(form.getTestament());
        this.description = form.getDescription();
    }

    private String convertTestament(Integer testament) {
        if (testament == 0)
            return "OLD";
        else
            return "NEW";
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public String getAbbrev() {
        return abbrev;
    }

    public String getLanguage() {
        return language;
    }

    public Integer getChapters() {
        return chapters;
    }

    public String getTestament() {
        return testament;
    }

    public String getDescription() {
        return description;
    }
}