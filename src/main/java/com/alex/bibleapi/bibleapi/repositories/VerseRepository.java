package com.alex.bibleapi.bibleapi.repositories;

import com.alex.bibleapi.bibleapi.domain.Verse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VerseRepository extends JpaRepository<Verse, Integer> {

    Optional<Verse> findByVersionAndBook_idAndChapterAndNumber(String version, Integer bookId, Integer chapter,
                                                               Integer number);

    List<Verse> findByVersionAndBook_idAndChapter(String version, Integer bookId, Integer chapter);
}
