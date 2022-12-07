package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController // Simplify the creation of RESTful web services, combines @Controller and @ResponseBody
@RequestMapping(path = "api/v1/student") // Used to map web requests to Spring Controller methods
public class StudentController {
    private final StudentService studentService;

    // Dependency injection: this @Autowired annotation will automatically instantiate the studentService needed
    // StudentService class must be a Spring Bean, annotate its class with @Component or more specific to our case:
    // @Service
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }

    /*@PutMapping
    public void updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
    }*/

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ) {
        studentService.updateStudent(studentId, name, email);
    }
}
