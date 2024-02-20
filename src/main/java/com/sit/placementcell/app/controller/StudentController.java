package com.sit.placementcell.app.controller;


import com.sit.placementcell.app.entity.AdminJobApplications;
import com.sit.placementcell.app.entity.JobAppliedStudents;
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


    @PostMapping("/check-already-applied")
    public ResponseEntity<Boolean> checkAlreadyApplied(@RequestBody Map<String,Integer> request){
        int jobId = request.get("jobId");
        int studentId = request.get("studentId");
        return ResponseEntity.ok(jobApplicationService.isAlreadyApplied(jobId,studentId));
    }


    @PostMapping("/apply-job")
    public ResponseEntity<String> applyForJob(@RequestBody Map<String, Integer> request) {
        int jobId = request.get("jobId");
        int studentId = request.get("studentId");
        String js = jobApplicationService.applyForJob(jobId,studentId);
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

    @PutMapping("/update-placement-willing")
    public boolean updatePlacementWilling(@RequestBody Map<String, String> data) {
        try {
            for (Map.Entry<String, String> entry : data.entrySet()) {
                String rollNo = entry.getKey();
                String status = entry.getValue();
                System.out.println(rollNo);
                System.out.println(status);
                Student student = studentService.findByRollNo(rollNo);

                if (student != null) {
                    if ("yes".equals(status)) {
                        student.setPlacementWilling("yes");
                    } else if ("no".equals(status)) {
                        student.setPlacementWilling("no");
                    } else {
                        System.out.println("Invalid status: " + status);
                    }
                    studentService.save(student);
                } else {
                    System.out.println("Student not found for rollNo: " + rollNo);
                }
            }
            return true; // Return true after processing all entries
        } catch (Exception e) {
            return false;
        }
    }

    @PostMapping("/get-selected-students")
    public ResponseEntity<List<AdminJobApplications>> getSelectedStudents(@RequestBody Map<String, Integer> request){
        Integer jobId = request.get("jobId");
        Integer statusId = request.get("statusId");
        System.out.println(jobId);
        System.out.println(statusId);
        List<AdminJobApplications> selectedList = jobApplicationService.findAllByJobAndStatus(jobId,statusId);
        if(selectedList == null){
            return ResponseEntity.ok(null);
        }else{
            return ResponseEntity.ok(selectedList);
        }
    }

}
