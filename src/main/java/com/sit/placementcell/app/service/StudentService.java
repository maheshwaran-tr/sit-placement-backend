package com.sit.placementcell.app.service;


import com.sit.placementcell.app.entity.Student;
import com.sit.placementcell.app.repository.JobApplicationRepository;
import com.sit.placementcell.app.repository.StudentRepository;
import com.sit.placementcell.app.token.TokenRepository;
import com.sit.placementcell.app.user.User;
import com.sit.placementcell.app.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final JobApplicationRepository jobApplicationRepository;
    private final TokenRepository tokenRepository;
    private final UserRepository userRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, JobApplicationRepository jobApplicationRepository, TokenRepository tokenRepository, UserRepository userRepository) {
        this.studentRepository = studentRepository;
        this.jobApplicationRepository = jobApplicationRepository;
        this.tokenRepository = tokenRepository;
        this.userRepository = userRepository;
    }

    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    public Student findStudentById(int id){
        return studentRepository.findById(id).orElse(null);
    }

    public Student findByRollNo(String rollNo){
        return studentRepository.findByRollNo(rollNo).orElse(null);
    }

    @Transactional
    public Student save(Student newStudent){
        return studentRepository.save(newStudent);
    }

    @Transactional
    public void deleteStudentById(int id){
        Student student = studentRepository.findById(id).orElse(null);
        if(student != null){
            User user = userRepository.findByStudent(student).orElse(null);
            jobApplicationRepository.deleteByStudentId(id);
            studentRepository.deleteById(id);
            if(user != null){
                tokenRepository.deleteByUser(user.getUserId());
                userRepository.deleteById(user.getUserId());
            }
        }
    }

    public List<Student> findStudentsByDept(String dept){
        return studentRepository.findAllByDepartmentIgnoreCase(dept);
    }

    public List<Student> findStudentsPlacementWilling(String pws){
        return studentRepository.findAllByPlacementWillingIgnoreCase(pws);
    }
}
