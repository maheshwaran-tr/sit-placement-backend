package com.sit.placementcell.app.service;

import com.sit.placementcell.app.entity.Admin;
import com.sit.placementcell.app.repository.AdminRepository;
import com.sit.placementcell.app.repository.StaffRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {


    private final AdminRepository adminRepository;
    private final StaffRepository staffRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository, StaffRepository staffRepository) {
        this.adminRepository = adminRepository;
        this.staffRepository = staffRepository;
    }

    @Transactional
    public Admin save(Admin admin){
        staffRepository.save(admin.getStaff());
        return adminRepository.save(admin);
    }
}
