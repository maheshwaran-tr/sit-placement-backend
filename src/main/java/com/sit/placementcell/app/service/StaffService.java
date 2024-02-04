package com.sit.placementcell.app.service;


import com.sit.placementcell.app.entity.Staff;
import com.sit.placementcell.app.repository.StaffRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    private final StaffRepository staffRepository;


    @Autowired
    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public List<Staff> findAll() {
        return staffRepository.findAll();
    }

    public Staff findbyID(int theId) {
        return staffRepository.findById(theId).orElse(null);
    }

    public Staff findByStaffId(String staffId) {
        return staffRepository.findByStaffId(staffId).orElse(null);
    }

    @Transactional
    public Staff save(Staff theStaff) {
        return staffRepository.save(theStaff);
    }

    @Transactional
    public void deleteById(int theId) {
        staffRepository.deleteById(theId);
    }


}
