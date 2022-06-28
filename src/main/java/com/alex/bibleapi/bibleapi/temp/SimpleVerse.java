package com.alex.bibleapi.bibleapi.temp;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SimpleVerse {

    @NotNull(message = "The field `chapters` cannot be Null")
    private Integer number;

    @NotBlank(message = "The Field `text` cannot be Empty or Null")
    private String text;

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