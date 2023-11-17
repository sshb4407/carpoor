package com.project.carPoor.controller;

import com.project.carPoor.domain.Question;
import com.project.carPoor.service.AnswerService;
import com.project.carPoor.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Secured("ROLE_ADMIN")
@Controller
@RequiredArgsConstructor
@RequestMapping("/answer")
public class AnswerController {

    private final QuestionService questionService;
    private final AnswerService answerService;

    @PostMapping(value = "/create/{id}")
    @Transactional
    public String createAnswer(String content, @PathVariable("id") Long id) {

        Question question = this.questionService.getQuestion(id);

        question.setAnswerStatus("답변 완료");

        this.answerService.create(question, content);

        return "redirect:/member/admin";
    }


}
