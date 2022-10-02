package com.example.demo.student;

import com.example.demo.account.Account;
import com.example.demo.account.AccountRepository;
import com.example.demo.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service // The same functionality but a clearer annotation than @Component - A Java Bean
public class StudentService {

    private final StudentRepository studentRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, AccountRepository accountRepository) {
        this.studentRepository = studentRepository;
        this.accountRepository = accountRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {

        System.out.println(student.toString());
//        accountRepository.save(student.getAccount());
        studentRepository.save(student);
    }

    public void deleteStudent(UUID student_id) {
        Student student = studentRepository.findById(student_id).get();

        boolean exists = studentRepository.existsById(student_id);
//        Student student = studentRepository.findById(student_id);

        if(!exists){
            throw new IllegalStateException("Student with id" + student_id + "does not exist!");
        }

        UUID account_id = student.getAccount().getAccount_id();
        exists = accountRepository.existsById(account_id);

        if(!exists){
            throw new IllegalStateException("Account with id" + account_id + "does not exist!");
        }

        student.setAccount(null);
        studentRepository.save(student);
        studentRepository.deleteById(student_id);
        accountRepository.deleteById(account_id);
    }
//        return List.of(
//                new Student(
//                        UUID.randomUUID(),
//                        "mariam@gamil.com",
//                        "password",
//                        UUID.randomUUID(),
//                        "Mariam Theune",
//                        LocalDate.of(2000, 3, 3),
//                        "Twente",
//                        "Computer Science",
//                        "Java, PHP"
//                ),
//                new Student(
//                        UUID.randomUUID(),
//                        "popa@gamil.com",
//                        "password",
//                        UUID.randomUUID(),
//                        "Dimitar Popov",
//                        LocalDate.of(2000, 12, 20),
//                        "Twente",
//                        "Computer Science",
//                        "Java, JavaScript, Python, C++"
//                )
//        );
//    }

//    public Student getStudentByID(UUID uid){
//        return (Student) studentRepository.findById(uid);
//    }

}
