package com.example.demo.Vacancy;

import com.example.demo.account.Account;
import com.example.demo.account.AccountService;
import com.example.demo.student.Mapper;
import com.example.demo.student.RegisterStudentDTO;
import com.example.demo.student.Student;
import com.example.demo.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
public class VacancyController {

    private final VacancyService vacancyService; //This is the Java Bean
    @Autowired //Basically injects an instance of studentService in the constructor
    public VacancyController(VacancyService vacancyService){
        this.vacancyService = vacancyService;
    }


    @GetMapping("/api/vacancies/{id}")
    public Vacancy getCommentById(@PathVariable UUID id) throws Exception {
        return vacancyService.getVacancyById(id);
    }

    @GetMapping("/api/vacancies")
    public List<Vacancy> getVacancies(){
        return vacancyService.getVacancies();
    }


}
