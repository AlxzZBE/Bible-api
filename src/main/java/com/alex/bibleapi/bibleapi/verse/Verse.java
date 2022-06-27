package com.alex.bibleapi.bibleapi.verse;

import com.alex.bibleapi.bibleapi.book.Book;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Verse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private Book book;

    @NotBlank(message = "The Field `version` cannot be Empty or Null")
    @Column(nullable = false)
    private String version;

    @NotNull(message = "The field `chapters` cannot be Null")
    @Column(nullable = false)
    private Integer chapter;

    @NotNull(message = "The field `chapters` cannot be Null")
    @Column(nullable = false)
    private Integer number;

    @NotBlank(message = "The Field `text` cannot be Empty or Null")
    @Column(unique = true, nullable = false)
    private String text;

    public Book getBook() {
        return book;
    }

    public Integer getId() {
        return id;
    }

    public void setBook(Book book) {
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
