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


@RestController
@RequestMapping(path = "api/v1/vacancy")
public class VacancyController {

    private final VacancyService vacancyService; //This is the Java Bean
    @Autowired //Basically injects an instance of studentService in the constructor
    public VacancyController(VacancyService vacancyService){
        this.vacancyService = vacancyService;
    }

    @GetMapping
    public List<Vacancy> getVacancies(){
        return vacancyService.getVacancies();
    }



    @PostMapping
    @ResponseBody
    public void registerNewStudent(@RequestBody RegisterStudentDTO studentDTO){
        System.out.println(studentDTO.toString());
        Mapper modelMapper = new Mapper();

        Account account = modelMapper.toStudentAcccount(studentDTO);
        System.out.println(account.toString());
        Student student = modelMapper.toStudent(studentDTO);
        student.setAccount(account);

        accountService.addNewAccount(account);
        studentService.addNewStudent(student);
    }
}
