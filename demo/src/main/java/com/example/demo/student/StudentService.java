package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        System.out.println(student);
        Optional<Student> studentWithThisEmail = studentRepository.findByEmail(student.getEmail());
        if(studentWithThisEmail.isPresent()){
            throw new IllegalStateException("Email taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        if(!studentRepository.existsById(studentId)){
            throw new IllegalStateException("Student with id " + studentId + " does not exist.");
        }
        studentRepository.deleteById(studentId);
    }

    /*@Transactional
    public void updateStudent(Student updatedStudent){
        Optional<Student> studentWithThisId = studentRepository.findById(updatedStudent.getId());
        if (!studentWithThisId.isPresent()){
            throw new IllegalStateException("Student with id " + updatedStudent.getId() + " does not exist.");
        }
        studentWithThisId.get().setName(updatedStudent.getName());
        studentWithThisId.get().setEmail(updatedStudent.getEmail());

        studentRepository.save(studentWithThisId.get());
    }*/

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student studentWithThisId = studentRepository.findById(studentId).orElseThrow(
                () -> new IllegalStateException("Student with id " + studentId + " does not exist.")
        );

        if(name != null && name.length() > 0 && !name.equals(studentWithThisId.getName())){
            studentWithThisId.setName(name);
        }

        if(email != null && email.length() > 0 && !email.equals(studentWithThisId.getEmail())){
            Optional<Student> studentWithThisEmail = studentRepository.findByEmail(email);
            if(studentWithThisEmail.isPresent()) {
                throw new IllegalStateException("Email taken");
            }

            studentWithThisId.setEmail(email);
        }

        studentRepository.save(studentWithThisId);
    }
}
