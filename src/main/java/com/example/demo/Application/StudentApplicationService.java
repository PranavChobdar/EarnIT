package com.example.demo.Application;

import com.example.demo.Vacancy.Vacancy;
import com.example.demo.Vacancy.VacancyRepository;
import com.example.demo.student.Student;
import com.example.demo.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StudentApplicationService {

    private final StudentApplicationRepository studentApplicationRepository;
    private final StudentRepository studentRepository;
    private final VacancyRepository vacancyRepository;

    @Autowired
    public StudentApplicationService(StudentApplicationRepository studentApplicationRepository, StudentRepository studentRepository, VacancyRepository vacancyRepository) {
        this.studentApplicationRepository = studentApplicationRepository;
        this.studentRepository = studentRepository;
        this.vacancyRepository = vacancyRepository;
    }

    public void addApplication(UUID student_id, UUID vacancy_id) throws Exception{
        //Get the student and vacancy from the database
        Student student = studentRepository.findById(student_id).orElseThrow(() -> new Exception("There is no student associated with this application!"));
        Vacancy vacancy = vacancyRepository.findById(vacancy_id).orElseThrow(() -> new Exception("addApplication(): There is no such vacancy!"));
        //Create a new application for this student and vacancy
        Application application = new Application();
        //Here we call the method that connects vacancy, student and application for us
        student.addApplication(application, vacancy);
//        vacancy.addApplication(application);
        //Since this reposistory extends ApplicationRepository it can also save applications:
        studentApplicationRepository.save(application);
        studentRepository.save(student);
        vacancyRepository.save(vacancy);
    }
}
