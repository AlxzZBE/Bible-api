package com.alex.bibleapi.bibleapi.requests.book;

import com.alex.bibleapi.bibleapi.domain.Book;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BookPostRequestBody {

    private String author;

    @NotBlank(message = "The Field `name` cannot be Empty or Null")
    private String name;

    @NotBlank(message = "The Field `abbrev` cannot be Empty or Null")
    @Length(min = 2, max = 2, message = "The field `abbrev` only should be 2 characters")
    private String abbrev;

    @NotBlank(message = "The Field `language` cannot be Empty or Null")
    private String language;

    @NotNull(message = "The field `chapters` cannot be Null")
    private Integer chapters;

    @NotNull(message = "The field `testament` cannot be Null")
    private Integer testament;

    private String description;

    public Book newBook(BookPostRequestBody form) {
        Book newBook = new Book();
        newBook.setAuthor(form.getAuthor());
        newBook.setName(form.getName());
        newBook.setAbbrev(form.getAbbrev());
        newBook.setLanguage(form.getLanguage());
        newBook.setChapters(form.getChapters());
        newBook.setTestament(form.getTestament());
        newBook.setDescription(form.getDescription());
        return newBook;
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

    public Integer getTestament() {
        return testament;
    }

    public void setTestament(Integer testament) {
        this.testament = testament;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "BookPostRequestBody{" +
                "author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", abbrev='" + abbrev + '\'' +
                ", language='" + language + '\'' +
                ", chapters=" + chapters +
                ", testament=" + testament +
                ", description='" + description + '\'' +
                '}';
    }
}