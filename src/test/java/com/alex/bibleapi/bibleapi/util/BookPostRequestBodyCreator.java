package com.alex.bibleapi.bibleapi.util;

import com.alex.bibleapi.bibleapi.domain.Book;
import com.alex.bibleapi.bibleapi.requests.book.BookPostRequestBody;

public class BookPostRequestBodyCreator {

    public static BookPostRequestBody createUserPostRequestBody() {
        Book validBook = BookCreator.createValidBook();
        return new BookPostRequestBody(validBook.getAuthor(), validBook.getName(), validBook.getAbbrev(),
                validBook.getLanguage(), validBook.getChapters(), validBook.getTestament(), validBook.getDescription());
    }
}