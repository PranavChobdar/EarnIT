package com.example.demo.Vacancy;

import com.example.demo.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

/**
 * If need be, consult this page regarding the difference between @RepositoryRestResource and @Repository
 * https://stackoverflow.com/questions/44264010/spring-difference-and-use-case-repository-and-repositoryrestresource
 */
public interface CompanyVacancyRepository extends VacancyRepository {
    Set<Vacancy> findAllByCompany(Company company);

}
