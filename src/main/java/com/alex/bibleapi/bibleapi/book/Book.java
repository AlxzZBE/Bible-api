package com.alex.bibleapi.bibleapi.book;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String author;

    @NotBlank(message = "The Field `name` cannot be Empty or Null")
    @Column(unique = true, nullable = false)
    private String name;

    @NotBlank(message = "The Field `abbrev` cannot be Empty or Null")
    @Column(unique = true, nullable = false)
    private String abbrev;

    @NotBlank(message = "The Field `language` cannot be Empty or Null")
    @Column(nullable = false)
    private String language;

    @NotNull(message = "The field `chapters` cannot be Null")
    private Integer chapters;

    @NotNull(message = "The field `testament` cannot be Null")
    private Integer testament;

    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(author, book.author) && Objects.equals(name, book.name) && Objects.equals(abbrev, book.abbrev) && Objects.equals(language, book.language) && Objects.equals(chapters, book.chapters) && Objects.equals(testament, book.testament) && Objects.equals(description, book.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, name, abbrev, language, chapters, testament, description);
    }

    public Integer getId() {
        return id;
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
}