package com.sit.placementcell.app.repository;

import com.sit.placementcell.app.entity.AdminJobApplications;
import com.sit.placementcell.app.entity.JobAppliedStudents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdminJobApplicationRepository extends JpaRepository<AdminJobApplications,Integer> {

    @Query("SELECT j FROM AdminJobApplications j WHERE j.status.statusId = :statusId")
    List<AdminJobApplications> findByStudentAndStatus(
            @Param("statusId") Integer statusId
    );

    @Query("SELECT j FROM AdminJobApplications j WHERE j.student.studentId = :studentId AND j.jobPost.jobId = :jobId")
    AdminJobApplications findByJobPostAndStudent(
            @Param("studentId") Integer studentId,
            @Param("jobId") Integer jobId
    );

    @Query("SELECT j FROM AdminJobApplications j WHERE j.jobPost.jobId = :jobId AND j.status.statusId = :statusId")
    List<AdminJobApplications> findByJobAndStatus(
            @Param("jobId") Integer jobId,
            @Param("statusId") Integer statusId
    );

    void deleteByJobPostJobId(Integer jobId);
}
