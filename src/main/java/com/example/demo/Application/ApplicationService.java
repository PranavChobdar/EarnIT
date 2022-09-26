package com.example.demo.Application;

import com.example.demo.Vacancy.Vacancy;
import com.example.demo.Vacancy.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ApplicationService {
    private final ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public List<Application> getApplications(){return applicationRepository.findAll();}

    public Application getApplicationById(UUID id) throws Exception {
        return applicationRepository.findById(id).orElseThrow(() -> new Exception("No such vacancy found"));
    }

}
