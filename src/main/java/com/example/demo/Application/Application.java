package com.example.demo.Application;

import com.example.demo.Vacancy.Vacancy;
import com.example.demo.student.Student;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * One Student can have many applications for many vacancies to many Companies
 *
 * */

@Entity
@Table(name="applications")
public class Application implements Serializable {


    @Id
    //Generates an UUID for all new objects:
    @GeneratedValue
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "application_id")
    protected UUID application_id;

    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;

    @ManyToOne
    @JsonIgnoreProperties("applications")
    @JoinColumn(name="vacancy_id", nullable = false)
    private Vacancy vacancy;

    public Application() {
    }

    public Application(Student student, Vacancy vacancy) {
        this.student = student;
        this.vacancy = vacancy;
    }

    public UUID getApplication_id() {
        return application_id;
    }

    public void setApplication_id(UUID application_id) {
        this.application_id = application_id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Vacancy getVacancy() {
        return vacancy;
    }

    public void setVacancy(Vacancy vacancy) {
        this.vacancy = vacancy;
    }
}
