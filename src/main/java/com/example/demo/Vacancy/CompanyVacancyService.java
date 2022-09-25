package com.example.demo.Vacancy;


import com.example.demo.company.Company;
import com.example.demo.company.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CompanyVacancyService {

    CompanyVacancyRepository companyVacancyRepository;
    CompanyRepository companyRepository;

    @Autowired
    public CompanyVacancyService(CompanyVacancyRepository companyVacancyRepository, CompanyRepository companyRepository) {
        this.companyVacancyRepository = companyVacancyRepository;
        this.companyRepository = companyRepository;
    }

    public void addVacancyToCompany(UUID company_id, Vacancy vacancy) throws Exception {
        Company company = companyRepository.findById(company_id).orElseThrow(() -> new Exception("There is no such company!"));
        company.addVacancy(vacancy);
        vacancy.setCompany(company);
        companyVacancyRepository.save(vacancy);
        companyRepository.save(company);
    }
}
