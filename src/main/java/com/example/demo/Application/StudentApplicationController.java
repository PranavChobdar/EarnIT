package com.example.demo.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class StudentApplicationController {

    StudentApplicationService studentApplicationService;
    @Autowired
    public StudentApplicationController(StudentApplicationService studentApplicationService) {
        this.studentApplicationService = studentApplicationService;
    }

    @PostMapping("/api/students/{student_id}/applications/{vacancy_id}")
    public void addApplication(@PathVariable UUID student_id, @PathVariable UUID vacancy_id) throws Exception{
        studentApplicationService.addApplication(student_id, vacancy_id);
    }
}
