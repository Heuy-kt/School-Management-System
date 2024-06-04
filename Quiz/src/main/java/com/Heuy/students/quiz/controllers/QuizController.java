package com.Heuy.students.quiz.controllers;

import com.Heuy.students.quiz.entities.Question;
import com.Heuy.students.quiz.services.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("heuy/v1/quiz")
@RequiredArgsConstructor
@Slf4j
public class QuizController {
    private final QuestionService questionService;

    public void addAquestion(@RequestBody Question question){

    }
}
