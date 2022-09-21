package com.example.demo.company;

import com.example.demo.account.Account;
import com.example.demo.account.AccountService;
import com.example.demo.student.Mapper;
import com.example.demo.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import org.modelmapper.ModelMapper;


import java.nio.channels.AcceptPendingException;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

@RestController
@RequestMapping(path = "api/v1/company")
public class CompanyController {

    private CompanyService companyService;
    private AccountService accountService;

    @Autowired
    public CompanyController(CompanyService companyService, AccountService accountService) {
        this.companyService = companyService;
        this.accountService = accountService;
    }

    @GetMapping
    public List<Company> getCompanies(){
        return companyService.getCompanies();
    }

    @PostMapping
    @ResponseBody
    public void registerNewCompany(@RequestBody RegisterCompanyDTO companyDTO){
        Mapper modelMapper = new Mapper();

        Account account = modelMapper.toCompanyAccount(companyDTO);
        Company company = modelMapper.toCompany(companyDTO);
        company.setAccount(account);
        System.out.println(account.toString());
        System.out.println(company.toString());
        accountService.addNewAccount(account);
        companyService.addNewCompany(company);



    }
}
