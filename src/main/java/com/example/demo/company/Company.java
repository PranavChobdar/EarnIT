package com.example.demo.company;

import com.example.demo.account.Account;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
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
    private UUID cid;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

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
                "cid=" + cid +
                ", account=" + account +
                ", name='" + name + '\'' +
                ", text='" + field + '\'' +
                ", location='" + location + '\'' +
                ", contact_person='" + contact_person + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
