package com.sit.placementcell.app.repository;

import com.sit.placementcell.app.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
}
