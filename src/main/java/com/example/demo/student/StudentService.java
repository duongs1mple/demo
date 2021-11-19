package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

//Normal annotation , but in Spring we can be more specific @Service same as @Component
//@Component
@Service  // to tell that this class is a Service class
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() { // auto doi ten List<Student> thanh List<Serializable> ????
        return studentRepository.findAll(); // A method of JPA to Return a list
    }

    public void addNewStudent(Student student) {
        System.out.println(student);
    }
}
