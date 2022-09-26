package com.example.demo.Vacancy;

import com.example.demo.company.Company;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;

public class VacancyDTO {

    private UUID company_id;
    private String position;
    private String method_of_work;

    public UUID getCompany_id() {
        return company_id;
    }

    public void setCompany_id(UUID company_id) {
        this.company_id = company_id;
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
