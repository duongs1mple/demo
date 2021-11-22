package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

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
        //studentRepository.findStudentByEmail(student.getEmail());
        //Ctrl + Alt + V => the following :
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("Email already exists");
        }
        //save student if he/she is not in the system
        studentRepository.save(student);
        System.out.println(student);
    }
    // Business logic for Delete Request
    public void deleteStudent(Long studentId) {
        //studentRepository.findById(studentId);  Ctrl + Alt + V => following
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("student with Id "+ studentId + "  does not exist");
        }
        studentRepository.deleteById(studentId); 
    }
    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
    }
}
