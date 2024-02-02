package com.sit.placementcell.app.controller;

import com.sit.placementcell.app.entity.Staff;
import com.sit.placementcell.app.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sit/staffs")
public class StaffController {

    @Autowired
    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping("/profile")
    public ResponseEntity<Staff> getProfile(){
        try{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String staffId = authentication.getName();
            return ResponseEntity.ok(staffService.findByStaffId(staffId));
        }catch (Exception e){
            return ResponseEntity.ok(null);
        }

    }

    @GetMapping("/all")
    public ResponseEntity<List<Staff>> getAllStaffs(){
        try{
            return ResponseEntity.ok(staffService.findAll());
        }catch (Exception e){
            return ResponseEntity.ok(null);
        }
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Staff> getById(@PathVariable int id){
        try{
            return ResponseEntity.ok(staffService.findbyID(id));
        }catch(Exception e){
            return ResponseEntity.ok(null);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Staff> addStaff(@RequestBody Staff theStaff){
        try{
            theStaff.setStaffDBID(0);
            Staff dbStaff = staffService.save(theStaff);
            return ResponseEntity.ok(dbStaff);
        }catch (Exception e){
            return ResponseEntity.ok(null);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Staff> updateStaff(@RequestBody Staff theStaff){
        try{
            Staff dbStaff = staffService.save(theStaff);
            return ResponseEntity.ok(dbStaff);
        }catch (Exception e){
            return ResponseEntity.ok(null);
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStaff(@PathVariable int id){
        try {
            Staff theStaff = staffService.findbyID(id);
            if(theStaff == null){
                throw new RuntimeException("Staff " + id + " Not Found");
            }
            staffService.deleteById(id);
            return ResponseEntity.ok("Staff Deleted "+id);
        } catch (Exception e) {
            return ResponseEntity.ok(null);
        }
    }

}