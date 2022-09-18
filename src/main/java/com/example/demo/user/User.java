package com.example.demo.user;

import javax.persistence.*;
import java.util.UUID;
//@Entity(name = "user")
//@Table
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="user_type",
//        discriminatorType = DiscriminatorType.INTEGER)
@Entity

@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="users")
public class User {
    @Id
    protected UUID uid;
    protected Integer user_type;
    protected String email;
    protected String password;

    public int getUser_type() {
        return user_type;
    }

    public void setUser_type(int user_type) {
        this.user_type = user_type;
    }


    public User(UUID uid, Integer user_type, String email, String password) {
        this.uid = UUID.randomUUID();
        this.user_type = user_type;
        this.email = email;
        this.password = password;
    }

    public User() {

    }

    public UUID getUid() {
        return uid;
    }

    public void setUid(UUID uid) {
        this.uid = uid;
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
}
