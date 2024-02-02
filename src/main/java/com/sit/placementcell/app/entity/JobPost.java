package com.sit.placementcell.app.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "job_post")
public class JobPost extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private Integer jobId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_details")
    private String companyDetails;

    @Column(name = "required_skills")
    private String requiredSkills;

    @Column(name = "history_of_arrears")
    private String historyOfArrears;

    @Column(name = "job_name")
    private String jobName;

    @Column(name = "job_description")
    private String jobDescription;

    @Column(name = "campus_mode")
    private String campusMode;

    @Column(name = "eligible_10th_mark")
    private double eligible10thMark;

    @Column(name = "eligible_12th_mark")
    private double eligible12thMark;

    @Column(name = "eligible_cgpa_mark")
    private double eligibleCGPAMark;

    @Column(name = "venue")
    private String venue;

    @Column(name = "interview_date")
    private String interviewDate;

    @Column(name = "interview_time")
    private String interviewTime;
}
