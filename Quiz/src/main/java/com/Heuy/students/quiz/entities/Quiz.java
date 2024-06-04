package com.Heuy.students.quiz.entities;
import com.Heuy.students.quiz.ENUMS.Difficulty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Table(name = "quizzes")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    @ManyToMany
    private List<Question> questions;

}
