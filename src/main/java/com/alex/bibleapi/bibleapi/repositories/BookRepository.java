package com.alex.bibleapi.bibleapi.repositories;

import com.alex.bibleapi.bibleapi.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    Optional<Book> findByAbbrev(String abbrev);

    List<Book> findByLanguage(String language);
}
