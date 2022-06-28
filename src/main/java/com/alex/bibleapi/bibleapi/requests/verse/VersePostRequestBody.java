package com.alex.bibleapi.bibleapi.requests.verse;

import com.alex.bibleapi.bibleapi.domain.Book;
import com.alex.bibleapi.bibleapi.domain.Verse;

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

    public Integer getChapter() {
        return chapter;
    }

    public Integer getNumber() {
        return number;
    }

    public String getText() {
        return text;
    }
}