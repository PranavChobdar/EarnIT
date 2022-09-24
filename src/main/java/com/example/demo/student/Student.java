package com.example.demo.student;

import com.example.demo.Application.Application;
import com.example.demo.Vacancy.Vacancy;
import com.example.demo.account.Account;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
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
    protected UUID student_id;

    //Sets up account_id as an FK in students table
//    @OneToOne(cascade = CascadeType.ALL)
//    @OneToOne(cascade = CascadeType.ALL)
    @OneToOne
    @JoinColumn(name = "account_id")
//    @JsonProperty("account")
    private Account account;

    @OneToMany(mappedBy = "student")
    Set<Application> applications = new HashSet<>();

    protected String name;
    protected LocalDate dob;
    protected String university;
    protected String course;
    protected String skills;



   public void addApplication(Application application, Vacancy vacancy){
       this.applications.add(application);
       application.setStudent(this);
       vacancy.addApplication(application);
   }
   public void updateApplication(Application oldApplication, Application newApplication, Vacancy vacancy){
       this.applications.remove(oldApplication);
       this.applications.add(newApplication);
       newApplication.setStudent(this);
       vacancy.updateApplication(oldApplication, newApplication);
   }
   public void removeApplication(Application application, Vacancy vacancy){
       this.applications.remove(application);
//       application.setStudent(this);
       vacancy.removeApplication(application);
   }

   public Application findApplicationMatch(Application application){
       for (Application app : this.applications){
           if (app.equals(application)){
               return app;
           }
       }
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

    public Student(String name, LocalDate dob, String university, String course, String skills) {
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

    public UUID getStudent_id() {
        return student_id;
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

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + student_id +
                ", account=" + account +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", university='" + university + '\'' +
                ", course='" + course + '\'' +
                ", skills='" + skills + '\'' +
                '}';
    }
}

