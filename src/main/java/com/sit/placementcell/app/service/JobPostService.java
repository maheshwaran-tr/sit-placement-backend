package com.sit.placementcell.app.service;


import com.sit.placementcell.app.entity.JobPost;
import com.sit.placementcell.app.repository.JobPostRepository;
import com.sit.placementcell.app.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostService {

    private final JobPostRepository jobPostRepository;
    private final StudentRepository studentRepository;
    @Autowired
    public JobPostService(JobPostRepository jobPostRepository, StudentRepository studentRepository) {
        this.jobPostRepository = jobPostRepository;
        this.studentRepository = studentRepository;
    }

    public List<JobPost> findAll(){
        return jobPostRepository.findAll();
    }

    public JobPost findByJobId(int id){
        return jobPostRepository.findById(id).orElse(null);
    }

    @Transactional
    public JobPost save(JobPost newJob){
        return jobPostRepository.save(newJob);
    }

    @Transactional
    public void delete(int id){
        jobPostRepository.deleteById(id);
    }




}
