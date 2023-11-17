package com.project.carPoor.controller;

import com.project.carPoor.domain.Member;
import com.project.carPoor.domain.Question;
import com.project.carPoor.service.MemberService;
import com.project.carPoor.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/question")
@RequiredArgsConstructor
public class QuestionController {

    private final MemberService memberService;
    private final QuestionService questionService;

    @GetMapping("/create")
    public String showCreate(Principal principal, Model model) {

        Member member = this.memberService.getMemberByLoginId(principal.getName());

        model.addAttribute("member", member);

        return "/article/questionWrite";
    }

    @PostMapping("/create")
    public String createQuestion(QuestionForm questionForm, Principal principal) {

        Member member = this.memberService.getMemberByLoginId(principal.getName());

        this.questionService.save(member, questionForm.getIsPublic(), questionForm.getSubject(), questionForm.getContent());

        return "redirect:/member/showList";
    }

    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Long id) {

        Question question = this.questionService.getQuestion(id);

        model.addAttribute("member", question.getAuthor());
        model.addAttribute("question", question);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd");
        String formattedDate = question.getRegDate().format(formatter);
        model.addAttribute("formattedDate", formattedDate);

        System.out.println(question.getAnswer());

        return "article/questionDetail";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/delete")
    public String deleteQuestion(@RequestParam(value = "questionIds", required = false) List<Long> questionIds, Model model) {

        if(questionIds == null || questionIds.isEmpty()) {
            return "redirect:/member/admin";
        }

        this.questionService.deleteQuestionsByIds(questionIds);

        List<Question> questions = this.questionService.findAll();

        model.addAttribute("questions", questions);

        return "/admin/answer";
    }
}
