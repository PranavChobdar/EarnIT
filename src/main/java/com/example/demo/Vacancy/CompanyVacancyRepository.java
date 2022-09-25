package com.example.demo.Vacancy;

import com.example.demo.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CompanyVacancyRepository extends VacancyRepository {
    Set<Vacancy> findAllByCompany(Company company);

}
