package com.Heuy.students.quiz.entities;

import com.Heuy.students.quiz.ENUMS.Difficulty;
import com.Heuy.students.quiz.ENUMS.Options;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record StudentQuestion(
        String question,
        String category,
        Options a, String fillA,Options b,String fillB,Options c, String fillC, Options d, String fillD,
        Difficulty difficulty)
{}
