package com.example.demo.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service // The same functionality but a clearer annotation than @Component - A Java Bean
public class StudentService {

    public List<Student> getStudents(){
        return List.of(
                new Student(
                        UUID.randomUUID(),
                        "mariam@gamil.com",
                        "password",
                        UUID.randomUUID(),
                        "Mariam Theune",
                        LocalDate.of(2000, 3, 3),
                        "Twente",
                        "Computer Science",
                        "Java, PHP"
                ),
                new Student(
                        UUID.randomUUID(),
                        "popa@gamil.com",
                        "password",
                        UUID.randomUUID(),
                        "Dimitar Popov",
                        LocalDate.of(2000, 12, 20),
                        "Twente",
                        "Computer Science",
                        "Java, JavaScript, Python, C++"
                )
        );
    }
}
