package com.example.demo.student;

import com.example.demo.account.Account;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="students")
//@PrimaryKeyJoinColumn(name = "uid") // --> This is an inheritance mapping strategy. It requires a join with database.User every time we want to use database.Student, so instead @JoinColumn is used
public class Student{


    @Id
    @GeneratedValue
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "student_id")
    protected UUID sid;



    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account; //remove
    protected String name;
    protected LocalDate dob;
    protected String university;
    protected String course;
    protected String skills;

    public Student(){
        super();
    }

//    public Student(UUID uid,String email, String password, UUID sid, String name, LocalDate dob, String university, String course, String skills) {
////        this.uid = uid;
////        this.email = email;
////        this.password = password;
//        super(uid, 1, email, password);
//        this.sid = UUID.randomUUID();
//        this.name = name;
//        this.dob = dob;
//        this.university = university;
//        this.course = course;
//        this.skills = skills;
//    }

    public Student( String email, String password, String name, LocalDate dob, String university, String course, String skills) {
        this.account = new Account(1,email, password);
        this.name = name;
        this.dob = dob;
        this.university = university;
        this.course = course;
        this.skills = skills;
    }

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

