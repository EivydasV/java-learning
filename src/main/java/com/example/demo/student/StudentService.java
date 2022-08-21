package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalArgumentException("email is already taken");
        }
        studentRepository.save(student);
    }
    public void deleteStudent(UUID studentId){
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalArgumentException("user with id " + studentId + " does not exists");
        }
        studentRepository.deleteById(studentId);
    }

    public void updateStudent(UUID studentId, String name, String email) {
    }
}
