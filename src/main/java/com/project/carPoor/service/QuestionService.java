package com.project.carPoor.service;

import com.project.carPoor.domain.Member;
import com.project.carPoor.domain.Question;
import com.project.carPoor.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public void save(Member member, Boolean isPublic, String subject, String content) {

        Question question = new Question();

        question.setAuthor(member);
        question.setIsPublic(isPublic);
        question.setSubject(subject);
        question.setContent(content);

        this.questionRepository.save(question);
    }

    public List<Question> findQuestionsByAuthorId(Long authorId) {

        return this.questionRepository.findByAuthorId(authorId);
    }

    public Question getQuestion(Long id) {

        Optional<Question> oq = this.questionRepository.findById(id);

        if(oq.isPresent()) {
            return oq.get();
        } else {
            throw new RuntimeException();
        }
    }

    public List<Question> findIsPublicQuestion() {

        return this.questionRepository.findByIsPublicTrueOrderByIdDesc();
    }

    public List<Question> findAll() {

        return this.questionRepository.findAll();
    }

    public void deleteQuestionsByIds(List<Long> questionIds) {

        List<Question> questionsToDelete = this.questionRepository.findAllById(questionIds);

        this.questionRepository.deleteAll(questionsToDelete);
    }
}
