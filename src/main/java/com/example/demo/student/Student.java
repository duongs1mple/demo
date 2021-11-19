package com.example.demo.student;



import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity //for Hibernate      //choose the persistence
@Table  // Create a Table name 'student' with following attributes in the DB
public class Student {
    @Id // ???
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1 //increment by 1
    )
    @GeneratedValue(
            //Recommened for PostgreS : sequence
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String name;
    private LocalDate dob; // must import LocalDate
    private String email;
    @Transient  // No longer count age as a column in the DB => auto calculated
    private Integer age;

    public Student() {
    }

    public Student(Long id, String name, LocalDate dob, String email) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
    }

    public Student(String name, LocalDate dob, String email) {
        this.name = name;
        this.dob = dob;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Calculate age , getYears , moc ban dau la dob , moc sau la hien tai
    //Method lay thoi gian between = cach lay tg hien tai tru di nam cua DoB
    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}