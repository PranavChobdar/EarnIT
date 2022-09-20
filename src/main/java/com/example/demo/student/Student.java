package com.example.demo.student;

import com.example.demo.account.Account;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="students")
//@PrimaryKeyJoinColumn(name = "uid") // --> This is an inheritance mapping strategy. It requires a join with database.User every time we want to use database.Student, so instead @JoinColumn is used
public class Student{


    @Id
    //Generates an UUID for all new objects:
    @GeneratedValue
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "student_id")
    protected UUID sid;

    //Sets up account_id as an FK in students table
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
//    @JsonProperty("account")
    private Account account;
    protected String name;
    protected LocalDate dob;
    protected String university;
    protected String course;
    protected String skills;
    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", account=" + account +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", university='" + university + '\'' +
                ", course='" + course + '\'' +
                ", skills='" + skills + '\'' +
                '}';
    }



    public Student(){
        super();
    }

    public Student( String email, String password, String name, LocalDate dob, String university, String course, String skills) {
        this.account = new Account(1,email, password);
        this.name = name;
        this.dob = dob;
        this.university = university;
        this.course = course;
        this.skills = skills;
    }

    public Student(Account account, String name, LocalDate dob, String university, String course, String skills) {
        this.account = account;
        this.name = name;
        this.dob = dob;
        this.university = university;
        this.course = course;
        this.skills = skills;
    }

//    public Student(String name, LocalDate dob, String university, String course, String skills) {
//        this.name = name;
//        this.dob = dob;
//        this.university = university;
//        this.course = course;
//        this.skills = skills;
//    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    public UUID getSid() {
        return sid;
    }

    public void setSid(UUID sid) {
        this.sid = sid;
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



    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;    }

}

