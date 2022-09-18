package com.example.demo.student;

import com.example.demo.user.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
//@Table //THIS
//@DiscriminatorValue("1")
@PrimaryKeyJoinColumn(name = "uid")
public class Student extends User {

//    @SequenceGenerator(
//            name = "student_sequence",
//            sequenceName = "student_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "student_sequence"
//    )
    protected UUID sid;
//    @JoinColumn(foreignKey = @ForeignKey(name = "user"))
//    protected UUID uid;
    protected String name;
    protected LocalDate dob;
    protected String university;
    protected String course;
    protected String skills;

    public Student(){
        super();
    }

    public Student(UUID uid,String email, String password, UUID sid, String name, LocalDate dob, String university, String course, String skills) {
//        this.uid = uid;
//        this.email = email;
//        this.password = password;
        super(uid, 1, email, password);
        this.sid = UUID.randomUUID();
        this.name = name;
        this.dob = dob;
        this.university = university;
        this.course = course;
        this.skills = skills;
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

    @Override
    public UUID getUid() {
        return uid;
    }

    public void setUid(UUID uid) {
        this.uid = uid;
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
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", uid='" + uid + '\'' +
                ", university='" + university + '\'' +
                ", course='" + course + '\'' +
                ", skills='" + skills + '\'' +
                ", uid=" + uid +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
