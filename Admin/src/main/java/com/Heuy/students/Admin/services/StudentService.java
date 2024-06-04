package com.Heuy.students.Admin.services;

import com.Heuy.students.Admin.requests.StudentRegistrationRequest;
import com.Heuy.students.Admin.entites.Student;
import com.Heuy.students.Admin.repo.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public record StudentService(StudentRepository studentRepository) {
    public void registerStudent(StudentRegistrationRequest studentRequest) {
        Student student = Student.builder()
                .fullName(studentRequest.fullName())
                .matNo(studentRequest.matNo())
                .level(studentRequest.level()).build();
        studentRepository.save(student);
    }

    public ResponseEntity<Student> loginStudent(String matNo, String password){
        Student student = studentRepository.findByMatNo(matNo);
        if(student.getPassword().equals(password)){
            return new ResponseEntity<>(student, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }

    public ResponseEntity<List<Student>> getAllStudents(){
        return new ResponseEntity<>(studentRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<String> setPassword(long id, String newPassword, String oldPassword){
        Optional<Student> student = studentRepository.findById(id);
        if(student.get().getPassword().equals(oldPassword)) {
            studentRepository.updatePassword(id, newPassword);
            return new ResponseEntity<>("Password changed", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("password incorrect", HttpStatus.UNAUTHORIZED);
    }
}
