package com.alex.bibleapi.bibleapi.repositories;

import com.alex.bibleapi.bibleapi.domain.Verse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VerseRepository extends JpaRepository<Verse, Integer> {

    Optional<Verse> findByVersionAndChapterAndNumberAndBook_id(String version, Integer chapter, Integer number,
                                                               Integer bookId);

    List<Verse> findByVersionAndChapterAndBook_id(String version, Integer chapter, Integer bookId);
}
