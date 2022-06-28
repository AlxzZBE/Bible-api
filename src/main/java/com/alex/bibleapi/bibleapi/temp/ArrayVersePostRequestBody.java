package com.alex.bibleapi.bibleapi.temp;

import com.alex.bibleapi.bibleapi.domain.Book;
import com.alex.bibleapi.bibleapi.domain.Verse;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class ArrayVersePostRequestBody {

    @NotBlank(message = "The Field `version` cannot be Empty or Null")
    private String version;

    @NotNull(message = "The field `chapters` cannot be Null")
    private Integer chapter;

    private List<SimpleVerse> simpleVerses;


    public List<Verse> newVerses(ArrayVersePostRequestBody form, Book book) {
        List<Verse> verses = new ArrayList<>();

        for (SimpleVerse sv : form.getSimpleVerses()) {
            Verse newVerse = new Verse();
            newVerse.setBook(book);
            newVerse.setVersion(form.getVersion());
            newVerse.setChapter(form.getChapter());
            newVerse.setNumber(sv.getNumber());
            newVerse.setText(sv.getText());
            verses.add(newVerse);
        }
        return verses;
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

    public List<SimpleVerse> getSimpleVerses() {
        return simpleVerses;
    }

    public void setSimpleVerses(List<SimpleVerse> simpleVerses) {
        this.simpleVerses = simpleVerses;
    }
}