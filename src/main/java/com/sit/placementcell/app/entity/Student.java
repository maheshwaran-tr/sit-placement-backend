package com.sit.placementcell.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "rollno")
    private String rollNo;

    @Column(name = "regno")
    private String regNo;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "department")
    private String department;

    @Column(name = "cgpa")
    private double cgpa;

    @Column(name = "score_10th")
    private double score10th;

    @Column(name = "score_12th")
    private double score12th;

    @Column(name = "placement_willing")
    private String placementWilling;

    @Column(name = "community")
    private String community;

    @Column(name = "gender")
    private String gender;

    @Column(name = "section")
    private String section;

    @Column(name = "father_name")
    private String fatherName;

    @Column(name = "father_occupation")
    private String fatherOccupation;

    @Column(name = "mother_name")
    private String motherName;

    @Column(name = "mother_occupation")
    private String motherOccupation;

    @Column(name = "place_of_birth")
    private String placeOfBirth;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "board_10th")
    private String board10th;

    @Column(name = "year_of_passing_10th")
    private String yearOfPassing10th;

    @Column(name = "board_12th")
    private String board12th;

    @Column(name = "year_of_passing_12th")
    private String yearOfPassing12th;

    @Column(name = "score_diploma")
    private String scoreDiploma;

    @Column(name = "branch_diploma")
    private String branchDiploma;

    @Column(name = "year_of_passing_diploma")
    private String yearOfPassingDiploma;

    @Column(name = "permanent_address")
    private String permanentAddress;

    @Column(name = "present_address")
    private String presentAddress;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "parent_ph_no")
    private String parentPhoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "aadhar")
    private String aadhar;

    @Column(name = "batch")
    private Integer batch;

    @Column(name = "current_sem")
    private Integer currentSem;

    @Column(name = "I")
    private String I;

    @Column(name = "II")
    private String II;

    @Column(name = "III")
    private String III;

    @Column(name = "IV")
    private String IV;

    @Column(name = "V")
    private String V;

    @Column(name = "VI")
    private String VI;

    @Column(name = "VII")
    private String VII;

    @Column(name = "VIII")
    private String VIII;

    @Column(name = "skills")
    private String skills;

    @Column(name = "standing_arrears")
    private Integer standingArrears;

    @Column(name = "history_of_arrears")
    private Integer historyOfArrears;


}
