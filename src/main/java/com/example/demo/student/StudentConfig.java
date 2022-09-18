package com.example.demo.student;

import com.example.demo.account.Account;
import com.example.demo.account.AccountRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static java.time.Month.DECEMBER;
import static java.time.Month.MARCH;

/**
 * Configuration class for putting a student in the database
 * Seeder
 */
@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository, AccountRepository accountRepository){
        return args -> {

//            Student mariam = new Student(
//                    UUID.randomUUID(),
//                    "mariam@gamil.com",
//                    "password",
//                    UUID.randomUUID(),
//                    "Mariam Theune",
//                    LocalDate.of(2000, MARCH, 3),
//                    "Twente",
//                    "Computer Science",
//                    "Java, PHP"
//            );
//            Student popa = new Student(
//                    UUID.randomUUID(),
//                    "popa@gamil.com",
//                    "password",
//                    UUID.randomUUID(),
//                    "Dimitar Popov",
//                    LocalDate.of(2000, DECEMBER, 20),
//                    "Twente",
//                    "Computer Science",
//                    "Java, C++, SQL, Python, Javascript"
//            );
            Account mariam_account = new Account(1, "mariam@gamil.com",
                    "password");
            Student mariam = new Student(
                    mariam_account.getEmail(),
                    mariam_account.getPassword(),
                    "Mariam Theune",
                    LocalDate.of(2000, MARCH, 3),
                    "Twente",
                    "Computer Science",
                    "Java, PHP"
            );
            Account popa_account = new Account(1, "popa@gamil.com",
                    "password");
            Student popa = new Student(
                    popa_account.getEmail(),
                    popa_account.getPassword(),
                    "Dimitar Popov",
                    LocalDate.of(2000, DECEMBER, 20),
                    "Twente",
                    "Computer Science",
                    "Java, C++, SQL, Python, Javascript"
            );
//            userRepository.saveAll(
//                    List.of(
//                            new User(mariam.getUid(), 1, mariam.getEmail(), mariam.getPassword()),
//                            new User(popa.getUid(), 1, popa.getEmail(), popa.getPassword())
//                    )
//            );
            accountRepository.saveAll(List.of(mariam_account, popa_account));
            studentRepository.saveAll(List.of(mariam, popa));
        };
    }
}
