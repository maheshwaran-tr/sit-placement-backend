package com.sit.placementcell.app.service;

import com.sit.placementcell.app.entity.Admin;
import com.sit.placementcell.app.entity.AdminJobApplications;
import com.sit.placementcell.app.repository.AdminJobApplicationRepository;
import com.sit.placementcell.app.repository.AdminRepository;
import com.sit.placementcell.app.repository.StaffRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {


    private final AdminRepository adminRepository;
    private final StaffRepository staffRepository;
    private final AdminJobApplicationRepository adminJobRepo;

    @Autowired
    public AdminService(AdminRepository adminRepository, StaffRepository staffRepository, AdminJobApplicationRepository adminJobRepo) {
        this.adminRepository = adminRepository;
        this.staffRepository = staffRepository;
        this.adminJobRepo = adminJobRepo;
    }

    @Transactional
    public Admin save(Admin admin){
        staffRepository.save(admin.getStaff());
        return adminRepository.save(admin);
    }

    public List<AdminJobApplications> getStudentsByFilters(Integer statusId) {
        return adminJobRepo.findByStudentAndStatus(statusId);
    }

    public List<AdminJobApplications> findAllApplications(){
        return adminJobRepo.findAll();
    }

}