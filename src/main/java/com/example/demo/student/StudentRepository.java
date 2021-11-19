package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//generics => Have to specify the  type that this repository will work upon and id for the type
public interface StudentRepository extends JpaRepository<Student, Long > {
}

//this is the Data Access Layer , We want to use this Interface inside the Service