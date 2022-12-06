package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository
        extends JpaRepository<Student, Long> {

    Optional<Student> findStudentByEmail(String email);


    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findByEmail(String email); // Just the same as the method above but with explicit query
}
