package com.example.demo.Review;

import com.example.demo.student.Student;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "reviews")
public class Review implements Serializable {
    @Id
    @ManyToOne
    Student student;

}
