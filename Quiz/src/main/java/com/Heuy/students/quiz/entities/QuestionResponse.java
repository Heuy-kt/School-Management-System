package com.Heuy.students.quiz.entities;

import com.Heuy.students.quiz.ENUMS.Options;
import jakarta.persistence.*;
import lombok.*;

public record QuestionResponse(
        String question,
        boolean isCorrect){}
