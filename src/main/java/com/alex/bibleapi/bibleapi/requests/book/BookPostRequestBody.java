package com.alex.bibleapi.bibleapi.requests.book;

import com.alex.bibleapi.bibleapi.domain.Book;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BookPostRequestBody {

    private String author;

    @NotBlank(message = "The Field `name` cannot be Empty or Null")
    @Length(min = 2, message = "The field `name` should be 2 min characters")
    private String name;

    @NotBlank(message = "The Field `abbrev` cannot be Empty or Null")
    @Length(min = 2, max = 6, message = "The field `abbrev` should be 2 min characters and 6 max characters")
    private String abbrev;

    @NotBlank(message = "The Field `language` cannot be Empty or Null")
    @Length(min = 2, max = 6, message = "The field `language` should be 2 min characters and 2 max characters")
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

    public Integer getTestament() {
        return testament;
    }

    public String getDescription() {
        return description;
    }
}