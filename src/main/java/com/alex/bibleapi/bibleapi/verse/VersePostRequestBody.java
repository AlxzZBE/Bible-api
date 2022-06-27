package com.alex.bibleapi.bibleapi.verse;

import com.alex.bibleapi.bibleapi.book.Book;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class VersePostRequestBody {

    @NotBlank(message = "The Field `version` cannot be Empty or Null")
    private String version;

    @NotNull(message = "The field `chapters` cannot be Null")
    private Integer chapter;

    @NotNull(message = "The field `chapters` cannot be Null")
    private Integer number;

    @NotBlank(message = "The Field `text` cannot be Empty or Null")
    private String text;

    public Verse newVerse(VersePostRequestBody form, Book book) {
        Verse newVerse = new Verse();
        newVerse.setBook(book);
        newVerse.setVersion(form.getVersion());
        newVerse.setChapter(form.getChapter());
        newVerse.setNumber(form.getNumber());
        newVerse.setText(form.getText());
        return newVerse;
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
