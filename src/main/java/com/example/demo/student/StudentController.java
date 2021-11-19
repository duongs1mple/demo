package com.example.demo.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.io.Serializable;
@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    //Create a reference to studentService
    //final
    private final StudentService studentService;

    //Will not work because of no instance of studentService =>  add 'new' to constructor
    //Day la cach lam thu cong va thay vao do nen dung dependency injection = @AutoWired
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService =  studentService;
    }
    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
}
    //Post API
    @PostMapping
    //
    public void RegisterNewStudent(@RequestBody Student student){ // 'Student' comes from the client
        //Must create a method 'addNewStudent' in StudentService
        studentService.addNewStudent(student);

    }


}
