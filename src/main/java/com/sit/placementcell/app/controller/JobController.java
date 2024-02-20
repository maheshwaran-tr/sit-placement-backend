package com.sit.placementcell.app.controller;


import com.sit.placementcell.app.entity.JobPost;
import com.sit.placementcell.app.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sit/jobs")
public class JobController {

    @Autowired
    private final JobPostService jobPostService;

    public JobController(JobPostService theJobPostService){
        jobPostService = theJobPostService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<JobPost>> findAll(){

        try {
            return ResponseEntity.ok(jobPostService.findAll());
        } catch (Exception e) {
            return ResponseEntity.ok(null);
        }
    }

    @GetMapping("/id/{jobId}")
    public ResponseEntity<JobPost> findById(@PathVariable int jobId){
        try{
            return ResponseEntity.ok(jobPostService.findByJobId(jobId));
        }catch (Exception e){
            return ResponseEntity.ok(null);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<JobPost> postJob(@RequestBody JobPost theJob){
        try{
            theJob.setJobId(0);
            JobPost job = jobPostService.save(theJob);
            return ResponseEntity.ok(job);
        }catch (Exception e){
            return ResponseEntity.ok(null);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<JobPost> updateJob(@RequestBody JobPost theJob){
        try{
            return ResponseEntity.ok(jobPostService.save(theJob));
        }catch (Exception e){
            return ResponseEntity.ok(jobPostService.save(null));
        }
    }

    @DeleteMapping("/delete/{jobId}")
    public ResponseEntity<String> deleteJob(@PathVariable int jobId){
        try{
            jobPostService.delete(jobId);
            return ResponseEntity.ok("Job Deleted " + jobId);
        }catch (Exception e){
            return ResponseEntity.ok(null);
        }
    }
}
