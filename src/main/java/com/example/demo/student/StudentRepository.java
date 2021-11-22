package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
//generics => Have to specify the  type that this repository will work upon and id for the type
public interface StudentRepository
        extends JpaRepository<Student, Long > {

    //This similar to SELECT * FROM student WHERE email = ?
    //Way 1
    //Optional class dung de kiem tra xem 1 bien co ton tai gia tri cu the nao hay ko
    Optional<Student> findStudentByEmail(String email);

    /*
    Way 2 :
    This is JPQL , not a straight SQL
    'Student' is the class
    @Query("SELECT s FROM Student s WHERE s.email=?1");
    */
}

//this is the Data Access Layer , We want to use this Interface inside the Service