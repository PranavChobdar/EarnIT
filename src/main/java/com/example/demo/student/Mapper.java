package com.example.demo.student;

import com.example.demo.account.Account;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public Student toStudent(RegisterStudentDTO studentDTO, Account account){
        return new Student(account,studentDTO.getName(), studentDTO.getDob(), studentDTO.getUniversity(),studentDTO.getCourse(),studentDTO.getSkills());
    }
    public Account toAcccount(RegisterStudentDTO studentDTO){
        return new Account(1,studentDTO.getEmail(), studentDTO.getPassword());
    }
//    public Account toAcccount(RegisterCompanytDTO companytDTO){
//        return new Account(1, companytDTO.getEmail(), companyDTO.getPassword());
//    }
}

