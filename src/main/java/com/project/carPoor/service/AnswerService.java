package com.project.carPoor.service;

import com.project.carPoor.domain.Answer;
import com.project.carPoor.domain.Question;
import com.project.carPoor.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;

    public void create(Question question, String content) {

        Answer answer = new Answer();

        answer.setContent(content);
        answer.setQuestion(question);

        this.answerRepository.save(answer);
    }



}
