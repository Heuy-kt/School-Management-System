package com.Heuy.students.Admin.repo;

import com.Heuy.students.Admin.entites.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByMatNo(String matNo);

    @Modifying
    @Query("UPDATE Student s SET s.password = :password where id = :id")
    void updatePassword(long id, String password);

}
