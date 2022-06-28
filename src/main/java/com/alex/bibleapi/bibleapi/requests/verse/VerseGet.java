package com.alex.bibleapi.bibleapi.requests.verse;

import com.alex.bibleapi.bibleapi.domain.Verse;
import com.alex.bibleapi.bibleapi.requests.book.BookGet;

public class VerseGet {

    private BookGet book;
    private String version;
    private Integer chapter;
    private Integer number;
    private String text;

    public VerseGet(Verse form) {
        this.book = new BookGet(form.getBook());
        this.version = form.getVersion();
        this.chapter = form.getChapter();
        this.number = form.getNumber();
        this.text = form.getText();
    }

    public BookGet getBook() {
        return book;
    }

    public void setBook(BookGet book) {
        this.book = book;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getChapter() {
        return chapter;
    }

    public void setChapter(Integer chapter) {
        this.chapter = chapter;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
