package com.example.demo.account;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;
//@Entity(name = "account")
@Entity
@Table(name="accounts")
public class Account {
    @Id
    @GeneratedValue
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "account_id")
    protected UUID aid;
    protected Integer account_type;
    protected String email;
    protected String password;

    public Account() {

    }
    public Account(Integer account_type, String email, String password) {
        this.account_type = account_type;
        this.email = email;
        this.password = password;
    }

//
//    public Account(UUID aid, Integer account_type, String email, String password) {
//        this.aid = UUID.randomUUID();
//        this.account_type = account_type;
//        this.email = email;
//        this.password = password;
//    }

    public int getAccount_type() {
        return account_type;
    }

    public void setAccount_type(int account_type) {
        this.account_type = account_type;
    }

    public UUID getUid() {
        return aid;
    }

    public void setUid(UUID uid) {
        this.aid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Account{" +
                "aid=" + aid +
                ", account_type=" + account_type +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

