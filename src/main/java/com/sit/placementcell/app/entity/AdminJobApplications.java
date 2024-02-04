package com.sit.placementcell.app.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "admin_job_applied_students")
public class AdminJobApplications extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private int jobAppliedId;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private JobPost jobPost;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;
}
