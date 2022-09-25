package com.example.demo.Application;

import com.example.demo.Vacancy.Vacancy;
import com.example.demo.student.Student;

import javax.persistence.*;
import java.io.Serializable;

/**
 * One Student can have many applications for many vacancies to many Companies
 *
 * */

@Entity
@Table(name="applications")
public class Application implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;

    @Id
    @ManyToOne
    @JoinColumn(name="vacancy_id", nullable = false)
    private Vacancy vacancy;

    public Application() {
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
