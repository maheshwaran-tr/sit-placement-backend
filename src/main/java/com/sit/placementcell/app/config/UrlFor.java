package com.sit.placementcell.app.config;

public class UrlFor {

    // Student Urls
    static final String allStudents = "sit/students/all";
    static final String addStudents = "sit/students/add";
    static final String updateStudents = "sit/students/update";
    static final String deleteStudents = "sit/students/delete/{id}";
    static final String studentByToken = "sit/students/profile";
    static final String studentsByDept = "sit/students/dept/{dept}";
    static final String studentsByPlacementWilling = "sit/students/get-placement-willing-list/{val}";
    static final String applyJob = "sit/students/apply-job";
    static final String updatePlacementWilling = "sit/students/update-placement-willing/{val}";
    static final String allAppliedJobs = "sit/students/get-applied-jobs/{id}";

    // Staff Urls
    static final String allStaffs = "sit/staffs/all";
    static final String addStaffs = "sit/staffs/add";
    static final String updateStaffs = "sit/staffs/update";
    static final String deleteStaffs = "sit/staffs/delete/{id}";
    static final String staffByToken = "sit/staffs/profile";


    // Job Urls
    static final String allJobs = "sit/jobs/all";
    static final String addJobs = "sit/jobs/add";
    static final String updateJobs = "sit/jobs/update";
    static final String deleteJobs = "sit/jobs/delete/{id}";
}