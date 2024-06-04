package com.Heuy.students.quiz.serviceImpl;

import com.Heuy.students.quiz.entities.Question;
import com.Heuy.students.quiz.repo.QuestionRepo;
import com.Heuy.students.quiz.services.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepo questionRepo;
    @Override
    public ResponseEntity<String> createQuestion(Question question) {
        try{
            questionRepo.save(question);
            return new ResponseEntity(question.getQuestion() + " is saved", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Optional<Question>> getQuestion(long id) {
        try{
            return new ResponseEntity<>(questionRepo.findById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<String> deleteQuestion(long id) {
        try{
            if(questionRepo.findById(id).isPresent()){
                Optional<Question> question = questionRepo.findById(id);
                questionRepo.deleteById(id);
                return new ResponseEntity<>(question.get().getQuestion(), HttpStatus.OK);
            }
            return new ResponseEntity<>("Question doesn't exist", HttpStatus.NOT_FOUND);
        }catch(Exception e){
            return new ResponseEntity<>("Check Error", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> updateQuestion(long id, Question newQuestion) {
        try{
            questionRepo.updateQuestion(id, newQuestion);
            return new ResponseEntity<>("Question successfully updated", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("Error in input", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<List<Question>> getAllQuestion() {
        try{
            return new ResponseEntity<>(questionRepo.findAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
