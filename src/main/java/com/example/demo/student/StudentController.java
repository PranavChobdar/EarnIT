package com.example.demo.student;

import com.example.demo.account.Account;
import com.example.demo.account.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService; //This is the Java Bean
    private final AccountService accountService;
    @Autowired //Basically injects an instance of studentService in the constructor
    public StudentController(StudentService studentService, AccountService accountService){
        this.studentService = studentService;
        this.accountService = accountService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student_frontend){
//        System.out.println(student_frontend.toString());
        Account account = new Account(1, student_frontend.getAccount().getEmail(), student_frontend.getAccount().getPassword());
        Student student = new Student(account, student_frontend.getName(), student_frontend.getDob(),
                student_frontend.getUniversity(), student_frontend.getCourse(), student_frontend.getSkills());
        accountService.addNewAccount(account);
        studentService.addNewStudent(student);
    }
}
