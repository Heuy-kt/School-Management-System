package com.Heuy.students.quiz.entities;

import com.Heuy.students.quiz.ENUMS.Difficulty;
import com.Heuy.students.quiz.ENUMS.Options;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "heuy_questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String question;
    private String category;
    @Enumerated(EnumType.STRING)
    private Options a;
    private String fillA;
    @Enumerated(EnumType.STRING)
    private Options b;
    private String fillB;
    @Enumerated(EnumType.STRING)
    private Options c;
    private String fillC;
    @Enumerated(EnumType.STRING)
    private Options d;
    private String fillD;
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;
    @Enumerated(EnumType.STRING)
    private Options correctAnswer;

}
