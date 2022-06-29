package com.alex.bibleapi.bibleapi.controllers;

import com.alex.bibleapi.bibleapi.requests.book.BookGet;
import com.alex.bibleapi.bibleapi.requests.book.BookPostRequestBody;
import com.alex.bibleapi.bibleapi.services.BookService;
import com.alex.bibleapi.bibleapi.util.BookCreator;
import com.alex.bibleapi.bibleapi.util.BookPostRequestBodyCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;

@ExtendWith(SpringExtension.class)
class BookControllerTest {

    public static final int ID = 2;
    public static final String EXPECTED_AUTHOR = "Moisés";
    public static final String EXPECTED_NAME = "Gênesis";
    public static final String EXPECTED_ABBREV = "gn";
    public static final String EXPECTED_LANGUAGE = "pt";
    public static final Integer EXPECTED_CHAPTERS = 50;
    public static final String EXPECTED_TESTAMENT = "OLD";
    public static final String EXPECTED_DESCRIPTION = "DESC";

    @InjectMocks
    private BookController bookController;

    @Mock
    private BookService bookService;

    @BeforeEach
    void setUp() {
        MockHttpServletRequest mockRequest = new MockHttpServletRequest();
        ServletRequestAttributes attributes = new ServletRequestAttributes(mockRequest);
        RequestContextHolder.setRequestAttributes(attributes);

        BDDMockito.doNothing().when(bookService).save(ArgumentMatchers.any(BookPostRequestBody.class));

        BDDMockito.when(bookService.findByAbbrevOrThrowNotFoundException(ArgumentMatchers.anyString()))
                .thenReturn(BookCreator.createValidBook());

        BDDMockito.when(bookService.findAllByLanguage(ArgumentMatchers.anyString()))
                .thenReturn(List.of(BookCreator.createValidBook()));
    }

    @Test
    @DisplayName("save Returns Void When Successful")
    void saveOneBook_ReturnsVoid_WhenSuccessful() {
        BookPostRequestBody bookPostRequestBody = BookPostRequestBodyCreator.createUserPostRequestBody();
        ResponseEntity<Void> response = bookController.saveOneBook(bookPostRequestBody);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        Assertions.assertThat(response.getBody()).isNull();
        Assertions.assertThat(response.getHeaders().getLocation().getQuery())
                .isEqualTo("abbrev=" + EXPECTED_ABBREV);
        Mockito.verify(bookService, Mockito.times(1)).save(bookPostRequestBody);
    }

    @Test
    @DisplayName("findByAbbrev Returns a BookGet When Successful")
    void findByAbbrev_ReturnsBookGet_WhenSuccessful() {
        ResponseEntity<BookGet> response = bookController.findByAbbrev("gn");

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(response.getBody()).isNotNull().isExactlyInstanceOf(BookGet.class);
        Assertions.assertThat(response.getBody().getAuthor()).isEqualTo(EXPECTED_AUTHOR);
        Assertions.assertThat(response.getBody().getName()).isEqualTo(EXPECTED_NAME);
        Assertions.assertThat(response.getBody().getAbbrev()).isEqualTo(EXPECTED_ABBREV);
        Assertions.assertThat(response.getBody().getChapters()).isEqualTo(EXPECTED_CHAPTERS);
        Assertions.assertThat(response.getBody().getLanguage()).isEqualTo(EXPECTED_LANGUAGE);
        Assertions.assertThat(response.getBody().getTestament()).isEqualTo(EXPECTED_TESTAMENT);
        Assertions.assertThat(response.getBody().getDescription()).isEqualTo(EXPECTED_DESCRIPTION);
    }

    @Test
    @DisplayName("findAllByLanguage Returns List Of BookGet When Successful")
    void findAllByLanguage_ReturnsListOfBookGet_WhenSuccessful() {
        ResponseEntity<List<BookGet>> response = bookController.findAllByLanguage("pt");

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(response.getBody()).isNotNull();
        Assertions.assertThat(response.getBody().get(0)).isNotNull().isExactlyInstanceOf(BookGet.class);
        Assertions.assertThat(response.getBody().get(0).getAuthor()).isEqualTo(EXPECTED_AUTHOR);
        Assertions.assertThat(response.getBody().get(0).getName()).isEqualTo(EXPECTED_NAME);
        Assertions.assertThat(response.getBody().get(0).getAbbrev()).isEqualTo(EXPECTED_ABBREV);
        Assertions.assertThat(response.getBody().get(0).getChapters()).isEqualTo(EXPECTED_CHAPTERS);
        Assertions.assertThat(response.getBody().get(0).getLanguage()).isEqualTo(EXPECTED_LANGUAGE);
        Assertions.assertThat(response.getBody().get(0).getTestament()).isEqualTo(EXPECTED_TESTAMENT);
        Assertions.assertThat(response.getBody().get(0).getDescription()).isEqualTo(EXPECTED_DESCRIPTION);
    }
}