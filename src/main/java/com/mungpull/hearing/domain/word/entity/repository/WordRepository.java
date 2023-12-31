package com.mungpull.hearing.domain.word.entity.repository;

import com.mungpull.hearing.domain.word.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordRepository extends JpaRepository<Word, Long> {
    List<Word> findAllByType(int type);
}
