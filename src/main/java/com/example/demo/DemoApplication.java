package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable; // neu de ID la string thi phai import cai nay moi ko thay error
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
//@RestController // Makes this class serve  Rest endpoint that should be made available over the web

public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	//The only REST in this demo
//	@GetMapping  // @GetMapping("/hello") tells Spring to use helloworld method to answer request sent to the address local...8080/hello)
//	public List<Serializable> hello(){ // auto doi ten List<Student> thanh List<Serializable> ????
//			return List.of(
//					"abc",
//					22,
//					"Duong",
//					LocalDate.of(1999, Month.AUGUST,3),
//					"duongngo3899@gmail.com"
//			);
//		 // phai co cham phay sau cau lenh
//	}
}
