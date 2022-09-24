package com.example.demo.company;

import com.example.demo.Application.Application;
import com.example.demo.Vacancy.Vacancy;
import com.example.demo.account.Account;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="companies")
public class Company {

    @Id
    //Generates an UUID for all new objects:
    @GeneratedValue
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "company_id")
    private UUID company_id;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;


    @OneToMany(mappedBy = "company")
    Set<Vacancy> vacancies = new HashSet<>();

    private String name;
    private String field;
    private String location;
    private String contact_person;
    private String phone;


    public Company(){super();}

    public Company(Account account, String name, String field, String location, String contact_person, String phone) {
        this.account = account;
        this.name = name;
        this.field = field;
        this.location = location;
        this.contact_person = contact_person;
        this.phone = phone;
    }

    public Company(String email, String password, String name, String field, String location, String contact_person, String phone) {
        this.account = new Account(2,email, password);
        this.name = name;
        this.field = field;
        this.location = location;
        this.contact_person = contact_person;
        this.phone = phone;
    }

    public Company(String name, String field, String location, String contact_person, String phone) {
        this.name = name;
        this.field = field;
        this.location = location;
        this.contact_person = contact_person;
        this.phone = phone;
    }
    public void addVacancy(Vacancy vacancy){
        this.vacancies.add(vacancy);
        vacancy.setCompany(this);
    }
    public void updateVacancy(Vacancy oldVacancy, Vacancy newVacancy){
        this.vacancies.remove(oldVacancy);
        this.vacancies.add(newVacancy);
        newVacancy.setCompany(this);
    }

    public void removeVacancy(Vacancy vacancy){
//        THIS REMOVES the Applications for this vacancy for all students
        for(Application a : vacancy.getApplications()){
            a.getStudent().removeApplication(a,vacancy);
        }
        this.vacancies.remove(vacancy);
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContact_person() {
        return contact_person;
    }

    public void setContact_person(String contact_person) {
        this.contact_person = contact_person;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Company{" +
                "cid=" + company_id +
                ", account=" + account +
                ", name='" + name + '\'' +
                ", text='" + field + '\'' +
                ", location='" + location + '\'' +
                ", contact_person='" + contact_person + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
