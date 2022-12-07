package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.JANUARY;

@Configuration // Indicates that this class defines Bean methods
public class StudentConfig {

    @Bean // Indicates a Bean, which is an object instantiated and managed by Spring and can be used somewhere else
    // like autowired to methods/attributes
    CommandLineRunner commandLineRunner(
            StudentRepository repository){
        return args -> {
            Student mariam = new Student(
                    "Mariam",
                    "mariam.jamal@gmail.com",
                    LocalDate.of(2000, JANUARY, 5)
            );

            Student alex = new Student(
                    "Alex",
                    "alex@gmail.com",
                    LocalDate.of(2004, JANUARY, 5)
            );

            repository.saveAll(List.of(mariam, alex));
        };




    }
}
