package com.Heuy.students.quiz.services;

import com.Heuy.students.quiz.entities.Question;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    public ResponseEntity<String> createQuestion(Question question);
    public ResponseEntity<Optional<Question>> getQuestion(long id);
    public ResponseEntity<String> deleteQuestion(long id);
    public ResponseEntity<String> updateQuestion(long id, Question newQuestion);
    public ResponseEntity<List<Question>> getAllQuestion();

}
