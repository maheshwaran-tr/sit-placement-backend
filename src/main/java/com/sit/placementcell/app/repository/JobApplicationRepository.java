package com.sit.placementcell.app.repository;

import com.sit.placementcell.app.entity.JobAppliedStudents;
import com.sit.placementcell.app.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface JobApplicationRepository extends JpaRepository<JobAppliedStudents,Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM JobAppliedStudents jas WHERE jas.student.id = :studentId")
    void deleteByStudentId(@Param("studentId") int studentId);

    List<JobAppliedStudents> findByStudentStudentId(int studentId);

    @Query("SELECT DISTINCT jas.student FROM JobAppliedStudents jas " +
            "WHERE jas.student.studentId = :studentId " +
            "AND jas.jobPost.jobId = :jobId " +
            "AND jas.student.department = :departmentName " +
            "AND jas.status.statusId = :statusId")
    List<Student> findStudentsByFilters(
            @Param("studentId") Integer studentId,
            @Param("jobId") Integer jobId,
            @Param("departmentName") String departmentName,
            @Param("statusId") Integer statusId
    );

    @Query("SELECT j FROM JobAppliedStudents j WHERE j.student.studentId = :studentId AND j.jobPost.jobId = :jobId")
    JobAppliedStudents findByJobPostAndStudent(
            @Param("studentId") Integer studentId,
            @Param("jobId") Integer jobId
    );
}
