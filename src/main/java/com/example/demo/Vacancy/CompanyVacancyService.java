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

    public void addVacancyToCompany(UUID company_id, Vacancy vacancy){
        Company company = companyRepository.findById(company_id);
        company.addVacancy(vacancy);



        Movie movie = moviesRepository.findById(movieId);
        movie.addComment(comment);
        movieCommentsRepository.save(comment);
        moviesRepository.save(movie);
    }
}
