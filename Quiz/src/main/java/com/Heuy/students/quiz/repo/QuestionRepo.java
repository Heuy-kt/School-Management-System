package com.Heuy.students.quiz.repo;

import com.Heuy.students.quiz.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface QuestionRepo extends JpaRepository<Question, Long> {

    @Modifying
    @Query("UPDATE Question q SET q = :question WHERE q.id = :id")
    String updateQuestion(Long id, Question question);

    @Modifying
    @Query(value = "SELECT * from questions q WHERE q.category = :category ORDER BY RANDOM() LIMIT :noQ ", nativeQuery = true)
    List<Question> findRandomQuestionsForQuiz (int noQ, String category);

}
