package com.sit.placementcell.app.service;


import com.sit.placementcell.app.entity.JobAppliedStudents;
import com.sit.placementcell.app.entity.JobPost;
import com.sit.placementcell.app.entity.Status;
import com.sit.placementcell.app.entity.Student;
import com.sit.placementcell.app.repository.JobApplicationRepository;
import com.sit.placementcell.app.repository.JobPostRepository;
import com.sit.placementcell.app.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobApplicationService {

    private final JobPostRepository jobPostRepository;
    private final StudentRepository studentRepository;
    private final JobApplicationRepository jobApplicationRepository;

    @Autowired
    public JobApplicationService(JobPostRepository jobPostRepository, StudentRepository studentRepository, JobApplicationRepository jobApplicationRepository) {
        this.jobPostRepository = jobPostRepository;
        this.studentRepository = studentRepository;
        this.jobApplicationRepository = jobApplicationRepository;
    }

    public List<JobAppliedStudents> findAllByStudents(Integer studentId){
        return jobApplicationRepository.findByStudentStudentId(studentId);
    }

    public List<Student> getStudentsByFilters(Integer studentId, Integer jobId, String departmentName, Integer statusId) {
        return jobApplicationRepository.findStudentsByFilters(studentId, jobId, departmentName, statusId);
    }

    public JobAppliedStudents applyForJob(int jobId, int studentId) {

        JobAppliedStudents existingRecord = jobApplicationRepository.findByJobPostAndStudent(studentId,jobId);
        if(existingRecord == null) {
            Optional<JobPost> optionalJobPost = jobPostRepository.findById(jobId);
            Optional<Student> optionalStudent = studentRepository.findById(studentId);

            if (optionalJobPost.isPresent() && optionalStudent.isPresent()) {
                JobPost jobPost = optionalJobPost.get();
                Student student = optionalStudent.get();

                // Check if the student is eligible for the job based on your criteria
                if (isStudentEligibleForJob(student, jobPost)) {
                    // Create a JobAppliedStudents entity and save it
                    JobAppliedStudents jobAppliedStudents = new JobAppliedStudents();
                    jobAppliedStudents.setJobPost(jobPost);
                    jobAppliedStudents.setStudent(student);
                    jobAppliedStudents.setStatus(getDefaultApplicationStatus()); // You need to implement this method

                    jobApplicationRepository.save(jobAppliedStudents);
                    return jobAppliedStudents;
                } else {
                    // Student is not eligible for the job
                    return null;
                }
            }
        }
        return null;
    }

    private Status getDefaultApplicationStatus() {
        Status status = new Status();
        status.setStatusId(1);
        return status;
    }

    private boolean isStudentEligibleForJob(Student student, JobPost jobPost) {
        return true;
    }
}
