package com.sit.placementcell.app.service;


import com.sit.placementcell.app.entity.JobAppliedStudents;
import com.sit.placementcell.app.entity.JobPost;
import com.sit.placementcell.app.repository.AdminJobApplicationRepository;
import com.sit.placementcell.app.repository.JobApplicationRepository;
import com.sit.placementcell.app.repository.JobPostRepository;
import com.sit.placementcell.app.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostService {

    private final JobPostRepository jobPostRepository;
    private final JobApplicationRepository jobApplicationRepository;
    private final AdminJobApplicationRepository adminJobApplicationRepository;

    @Autowired
    public JobPostService(JobPostRepository jobPostRepository, JobApplicationRepository jobApplicationRepository, AdminJobApplicationRepository adminJobApplicationRepository) {
        this.jobPostRepository = jobPostRepository;
        this.jobApplicationRepository = jobApplicationRepository;
        this.adminJobApplicationRepository = adminJobApplicationRepository;
    }

    public List<JobPost> findAll() {
        return jobPostRepository.findAll();
    }

    public JobPost findByJobId(int id) {
        return jobPostRepository.findById(id).orElse(null);
    }

    @Transactional
    public JobPost save(JobPost newJob) {
        return jobPostRepository.save(newJob);
    }

    @Transactional
    public void delete(int id) {
        adminJobApplicationRepository.deleteByJobPostJobId(id);
        jobApplicationRepository.deleteByJobPostJobId(id);
        jobPostRepository.deleteById(id);
    }
}
