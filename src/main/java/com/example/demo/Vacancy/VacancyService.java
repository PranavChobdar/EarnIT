package com.example.demo.Vacancy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VacancyService {

    private final VacancyRepository vacancyRepository;

    @Autowired
    public VacancyService(VacancyRepository vacancyRepository) {
        this.vacancyRepository = vacancyRepository;
    }
    public List<Vacancy> getVacancies(){
        return vacancyRepository.findAll();
    }


    public Vacancy getVacancyById(UUID id) throws Exception {
        return vacancyRepository.findById(id).orElseThrow(() -> new Exception("No such vacancy found!"));
    }
}
