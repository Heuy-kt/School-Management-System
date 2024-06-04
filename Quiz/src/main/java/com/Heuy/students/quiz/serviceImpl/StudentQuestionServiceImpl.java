package com.Heuy.students.quiz.serviceImpl;

import com.Heuy.students.quiz.entities.Question;
import com.Heuy.students.quiz.entities.StudentQuestion;
import com.Heuy.students.quiz.repo.QuestionRepo;
import com.Heuy.students.quiz.services.StudentQuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public record StudentQuestionServiceImpl(QuestionRepo questionRepo) implements StudentQuestionService{
    @Override
    public ResponseEntity<List<StudentQuestion>> getAllQuestions() {
        List<StudentQuestion> questionForStudent = new ArrayList<>();
        List<Question> allQuestions = questionRepo.findAll();
        allQuestions.forEach(q -> {
            StudentQuestion sq = new StudentQuestion(q.getQuestion(), q.getCategory(), q.getA(), q.getFillA(), q.getB(), q.getFillB(), q.getC(), q.getFillC(), q.getD(), q.getFillD(), q.getDifficulty());
            questionForStudent.add(sq);
        });
        return new ResponseEntity<>(questionForStudent, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<StudentQuestion> getQuestion(long id) {
        try{
            Optional<Question> q = questionRepo.findById(id);
            StudentQuestion sq = new StudentQuestion(q.get().getQuestion(), q.get().getCategory(), q.get().getA(), q.get().getFillA(), q.get().getB(), q.get().getFillB(), q.get().getC(), q.get().getFillC(), q.get().getD(), q.get().getFillD(), q.get().getDifficulty());
            return new ResponseEntity<>(sq, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
