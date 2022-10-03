package com.example.demo.Vacancy;

import com.example.demo.Application.Application;
import com.example.demo.company.Company;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="vacancies")
public class Vacancy {
    @Id
    @GeneratedValue
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "vacancy_id")
    protected UUID vacancy_id;

    @ManyToOne
//    @JsonIgnoreProperties("vacancies")
    @JoinColumn(name="company_id")
    private Company company;
    private String position;
    private String method_of_work;

    @OneToMany(mappedBy = "vacancy", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("vacancy")
    private Set<Application> applications = new HashSet<>();



    public Vacancy() {

    }
    public Vacancy(String position, String method_of_work) {
//        this.applications = new HashSet<>();
        this.position = position;
        this.method_of_work = method_of_work;
    }


    public void addApplication(Application application){
        this.applications.add(application);
        application.setVacancy(this);
    }

    public void updateApplication(Application oldApplication, Application newApplication){
        this.applications.remove(oldApplication);
        this.applications.add(newApplication);
        newApplication.setVacancy(this);
    }

    public void removeApplication(Application application){
        this.applications.remove(application);
//        application.setVacancy(this);
    }

    public UUID getVacancy_id() {
        return vacancy_id;
    }

    public void setVacancy_id(UUID vacancy_id) {
        this.vacancy_id = vacancy_id;
    }

    public Set<Application> getApplications() {
        return applications;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMethod_of_work() {
        return method_of_work;
    }

    public void setMethod_of_work(String method_of_work) {
        this.method_of_work = method_of_work;
    }
}
