package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository){ //inject repo to have access to repo
        return args -> {
            Student duong = new Student( // no Serializable error //use Ctrl+Alt+V => Refactor
                    //Remove ID since the DB generates automatically

                    "Duong",
                    LocalDate.of(1999, Month.AUGUST, 3),
                    "duongngo3899@gmail.com"
            );
            Student bong = new Student( // no Serializable error //use Ctrl+Alt+V => Refactor
                    //Remove ID since the DB generates automatically

                    "Bong",
                    LocalDate.of(1994, Month.JULY, 5),
                    "ditconmebong@gmail.com"
            );
            Student hanh = new Student( // no Serializable error //use Ctrl+Alt+V => Refactor
                    //Remove ID since the DB generates automatically

                    "Hanh",
                    LocalDate.of(1996, Month.FEBRUARY, 2),
                    "bakadog@gmail.com"
            );
            //invoke repo
            repository.saveAll(
                    List.of(duong, bong, hanh)
            ); // Save all students as a list
        };
    }
    }