package com.sit.placementcell.app.repository;

import com.sit.placementcell.app.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StaffRepository extends JpaRepository<Staff,Integer> {


    Optional<Staff> findByStaffId(String staffId);
}
