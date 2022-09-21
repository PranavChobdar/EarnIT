package com.example.demo.student;

import com.example.demo.account.Account;
import com.example.demo.company.Company;
import com.example.demo.company.RegisterCompanyDTO;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public Student toStudent(RegisterStudentDTO studentDTO){
        return new Student(studentDTO.getName(), studentDTO.getDob(), studentDTO.getUniversity(),studentDTO.getCourse(),studentDTO.getSkills());
    }
    public Account toStudentAcccount(RegisterStudentDTO studentDTO){
        return new Account(1,studentDTO.getEmail(), studentDTO.getPassword());
    }

    public Company toCompany(RegisterCompanyDTO companyDTO){
        return  new Company(companyDTO.getName(),  companyDTO.getField(), companyDTO.getLocation(), companyDTO.getContact_person(), companyDTO.getPhone());
    }

    public Account toCompanyAccount(RegisterCompanyDTO companyDTO){
        return new Account(2, companyDTO.getEmail(), companyDTO.getPassword());
    }


//    public Account toAcccount(RegisterCompanytDTO companytDTO){
//        return new Account(1, companytDTO.getEmail(), companyDTO.getPassword());
//    }
}

