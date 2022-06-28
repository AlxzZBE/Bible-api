package com.alex.bibleapi.bibleapi.requests.verse;

import com.alex.bibleapi.bibleapi.domain.Verse;
import com.alex.bibleapi.bibleapi.requests.book.BookGet;

import java.util.ArrayList;
import java.util.List;

public class ListVerseGet {

    private BookGet book;
    private List<OnlyVerse> verses = new ArrayList<>();

    public ListVerseGet(List<Verse> form) {
        for (Verse v : form) {
            this.book = new BookGet(v.getBook());
            setVerses(new OnlyVerse(v));
        }
    }

    public BookGet getBook() {
        return book;
    }

    public void setBook(BookGet book) {
        this.book = book;
    }

    public List<OnlyVerse> getVerses() {
        return verses;
    }

    public void setVerses(OnlyVerse onlyVerse) {
        this.verses.add(onlyVerse);
    }

    public static class OnlyVerse {
        private String version;
        private Integer chapter;
        private Integer number;
        private String text;

        public OnlyVerse(Verse form) {
            this.version = form.getVersion();
            this.chapter = form.getChapter();
            this.number = form.getNumber();
            this.text = form.getText();
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
}