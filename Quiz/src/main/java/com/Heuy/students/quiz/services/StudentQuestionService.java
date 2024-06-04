package com.Heuy.students.quiz.services;

import com.Heuy.students.quiz.entities.QuestionResponse;
import com.Heuy.students.quiz.entities.StudentQuestion;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentQuestionService {
    ResponseEntity<List<StudentQuestion>> getAllQuestions();
    ResponseEntity<StudentQuestion> getQuestion(long id);

}
