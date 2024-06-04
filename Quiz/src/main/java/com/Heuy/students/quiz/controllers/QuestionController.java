package com.Heuy.students.quiz.controllers;

import com.Heuy.students.quiz.entities.Question;
import com.Heuy.students.quiz.serviceImpl.QuestionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("app/v1/questions")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionServiceImpl questionService;

    @PostMapping("create")
    public ResponseEntity<String> createQuestion(@RequestBody Question question){
        return questionService.createQuestion(question);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Optional<Question>> getQuestion(@PathVariable long id){
        return questionService.getQuestion(id);
    }
}
