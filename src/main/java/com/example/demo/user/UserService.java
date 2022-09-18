package com.example.demo.user;

import com.example.demo.student.Student;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    public List<User> getUsers(){
        return List.of(
                new User(
                        UUID.randomUUID(),1,
                        "mariam@gamil.com",
                        "password"
                        ),
                new User(
                        UUID.randomUUID(), 1,
                        "popa@gamil.com",
                        "password"
                )
        );
    }
}
