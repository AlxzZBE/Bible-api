package com.alex.bibleapi.bibleapi.verse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VerseRepository extends JpaRepository<Verse, Integer> {

    Optional<Verse> findByVersionAndChapterAndNumberAndBook_id(String version, Integer chapter, Integer number,
                                                               Integer bookId);
}
