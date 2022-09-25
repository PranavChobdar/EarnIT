package com.example.demo.Vacancy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.modelmapper.ModelMapper;

import java.util.UUID;


@RestController
public class CompanyVancancyController {


    CompanyVacancyService companyVacancyService;
    @Autowired
    public CompanyVancancyController(CompanyVacancyService companyVacancyService) {
        this.companyVacancyService = companyVacancyService;
    }

    @PostMapping("/api/companies/{company_id}/vacancies")
    public void addCommentToMovie(@RequestBody VacancyDTO vacancyDTO, @PathVariable UUID company_id) throws Exception {
        Vacancy vacancy = convertToVacancy(vacancyDTO);
        companyVacancyService.addVacancyToCompany(company_id, vacancy);
    }

    private Vacancy convertToVacancy(VacancyDTO vacancyDTO) {
        /**
         * From the creation of Vacancy.java onward, we will use org.modelmapper.ModelMapper instead of the Mapper class
         * This will save a lot of work as methods for converting DTO objects to their original counterparts won't have to be implemented by hand.
         * READ MORE here: http://modelmapper.org/getting-started/
         */
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(vacancyDTO,Vacancy.class);
    }

}
