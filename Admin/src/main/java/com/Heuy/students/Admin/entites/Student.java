package com.Heuy.students.Admin.entites;

import com.Heuy.students.Admin.ENUMS.Levels;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Table(name = "students")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String fullName;
    private String matNo;
    private String password;
    private Boolean blacklisted;
    private Boolean feesPaid;
    @Enumerated(EnumType.STRING)
    private Levels level;


}
