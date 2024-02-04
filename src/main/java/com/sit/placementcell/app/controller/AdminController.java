package com.sit.placementcell.app.controller;


import com.sit.placementcell.app.entity.AdminJobApplications;
import com.sit.placementcell.app.entity.JobFilterFormat;
import com.sit.placementcell.app.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sit/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/get-student-by-dept-sts/{statusId}")
    public ResponseEntity<List<AdminJobApplications>> getStudentsByFilter(@PathVariable Integer statusId){
        System.out.println("***************");
        return ResponseEntity.ok(adminService.getStudentsByFilters(statusId));
    }

    @GetMapping("/get-all-applications")
    public ResponseEntity<List<AdminJobApplications>> getAll(){
        return ResponseEntity.ok(adminService.findAllApplications());
    }

}
