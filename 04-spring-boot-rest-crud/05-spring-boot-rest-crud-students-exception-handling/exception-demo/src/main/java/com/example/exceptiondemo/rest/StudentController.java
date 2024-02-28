package com.example.exceptiondemo.rest;

import com.example.exceptiondemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private List<Student> theStudents;

    @PostConstruct
    public void loadData() {
        theStudents = List.of(
                new Student("Poornima", "Patel"),
                new Student("Mario", "Rossi"),
                new Student("Mary", "Smith")
        );
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        System.out.println("size : "+theStudents.size());
        // check the studentId against list size
        if (studentId >= theStudents.size() || studentId < 0) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
       return theStudents.get(studentId);
    }

    // add exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {

        // create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(404);
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(error, org.springframework.http.HttpStatus.NOT_FOUND);
    }


    // add another exception handler ... to catch any exception (catch all)
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {

        // create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(400);
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(error, org.springframework.http.HttpStatus.BAD_REQUEST);
    }

}
