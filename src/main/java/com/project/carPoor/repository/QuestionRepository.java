package com.project.carPoor.repository;

import com.project.carPoor.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByAuthorId(Long authorId);

    List<Question> findByIsPublicTrueOrderByIdDesc();

}
