package com.example.demo.student;

import com.example.demo.account.Account;
import com.example.demo.account.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
//@RequestMapping(path = "api/student")
public class StudentController {

    private final StudentService studentService; //This is the Java Bean
    private final AccountService accountService;
    @Autowired //Basically injects an instance of studentService in the constructor
    public StudentController(StudentService studentService, AccountService accountService){
        this.studentService = studentService;
        this.accountService = accountService;
    }

    @GetMapping("/api/student")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

//    @PostMapping
//    public void registerNewStudent(@RequestBody Student student_payload){
////        System.out.println(student_frontend.toString());
//        Account account = new Account(student_payload.email)
//        Account account = new Account(1, student_payload.getAccount().getEmail(), student_payload.getAccount().getPassword());
//        Student student = new Student(account, student_payload.getName(), student_payload.getDob(),
//                student_payload.getUniversity(), student_payload.getCourse(), student_payload.getSkills());
//        accountService.addNewAccount(account);
//        studentService.addNewStudent(student);
//    }

    @PostMapping("/api/student/create")
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
    @DeleteMapping("/api/student/delete/{student_id}/{account_id}")
    public void deleteStudent(@PathVariable("student_id") UUID student_id, @PathVariable("account_id") UUID account_id){
//        accountService.deleteAccount(account_id);
        studentService.deleteStudent(student_id);

    }

}
