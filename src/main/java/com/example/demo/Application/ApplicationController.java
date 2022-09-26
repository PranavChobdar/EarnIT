package com.example.demo.Application;

import com.example.demo.Vacancy.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class ApplicationController {

    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(com.example.demo.Application.ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    //Returns all applications from the database
    @GetMapping("/api/applications")
    public List<Application> getApplications(){
        return applicationService.getApplications();
    }

    //Returns an application with a particular ID
    @GetMapping("/api/applications/{id}")
    public Application getApplicationById(@PathVariable UUID id) throws Exception{
        return applicationService.getApplicationById(id);
    }

}
