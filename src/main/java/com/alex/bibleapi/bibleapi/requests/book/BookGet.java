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

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getChapters() {
        return chapters;
    }

    public void setChapters(Integer chapters) {
        this.chapters = chapters;
    }

    public String getTestament() {
        return testament;
    }

    public void setTestament(String testament) {
        this.testament = testament;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}