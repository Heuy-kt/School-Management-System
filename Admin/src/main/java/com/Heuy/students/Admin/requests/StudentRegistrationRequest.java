package com.Heuy.students.Admin.requests;
import com.Heuy.students.Admin.ENUMS.Levels;

public record  StudentRegistrationRequest(
        String fullName,
        String matNo,
        Levels level
){}
