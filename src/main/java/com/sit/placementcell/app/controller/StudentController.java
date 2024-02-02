package com.sit.placementcell.app.controller;


import com.sit.placementcell.app.entity.JobAppliedStudents;
import com.sit.placementcell.app.entity.JobFilterFormat;
import com.sit.placementcell.app.entity.Student;
import com.sit.placementcell.app.service.JobApplicationService;
import com.sit.placementcell.app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sit/students")
public class StudentController {

    @Autowired
    private JobApplicationService jobApplicationService;

    @Autowired
    private StudentService studentService;



    @GetMapping("/profile")
    public ResponseEntity<Student> getProfile(){
        try{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String  studentRollNo = authentication.getName();
            return ResponseEntity.ok(studentService.findByRollNo(studentRollNo));
        }catch (Exception e){
            return ResponseEntity.ok(null);
        }
    }


    @GetMapping("/get-applied-jobs/{id}")
    public ResponseEntity<List<JobAppliedStudents>> findAllByStudent(@PathVariable int id){
        return ResponseEntity.ok(jobApplicationService.findAllByStudents(id));
    }

    @PostMapping("/filter")
    public ResponseEntity<List<Student>> getStudentsByFilter(@RequestBody JobFilterFormat jobFilterFormat){
        Integer jobId = jobFilterFormat.getJobId();
        Integer studentId = jobFilterFormat.getStudentId();
        Integer statusId = jobFilterFormat.getStatusId();
        String deptName = jobFilterFormat.getDept();
        return ResponseEntity.ok(jobApplicationService.getStudentsByFilters(studentId,jobId,deptName,statusId));
    }

    @PostMapping("/apply-job")
    public ResponseEntity<JobAppliedStudents> applyForJob(@RequestBody Map<String, Integer> request) {
        int jobId = request.get("jobId");
        int studentId = request.get("studentId");
        JobAppliedStudents js = jobApplicationService.applyForJob(jobId,studentId);
        return ResponseEntity.ok(js);
    }


    @GetMapping("/id/{id}")
    public ResponseEntity<Student> findStudentById(int id){
        try{
            return ResponseEntity.ok(studentService.findStudentById(id));
        }catch (Exception e){
            return ResponseEntity.ok(null);
        }

    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> findAllStudents(){
        try {
            return ResponseEntity.ok(studentService.findAllStudents());
        }catch (Exception e){
            return ResponseEntity.ok(null);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student newStudent){
        try{
            newStudent.setStudentId(0);
            return ResponseEntity.ok(studentService.save(newStudent));
        }catch (Exception e){
            return ResponseEntity.ok(null);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        try{
            return ResponseEntity.ok(studentService.save(student));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.ok(null);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        try{
            studentService.deleteStudentById(id);
            return ResponseEntity.ok("Student Deleted");
        }catch (Exception e){
            return ResponseEntity.ok(null);
        }
    }

    @GetMapping("/dept/{dept}")
    public ResponseEntity<List<Student>> findByDept(@PathVariable String dept){
        try{
            return ResponseEntity.ok(studentService.findStudentsByDept(dept));
        }catch (Exception e){
            return ResponseEntity.ok(null);
        }
    }

    @GetMapping("/get-placement-willing-list/{val}")
    public ResponseEntity<List<Student>> findByPws(@PathVariable String val){
        try{
            return ResponseEntity.ok(studentService.findStudentsPlacementWilling(val));
        }catch (Exception e){
            return ResponseEntity.ok(null);

        }
    }



}
