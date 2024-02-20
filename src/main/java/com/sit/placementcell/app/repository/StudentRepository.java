package com.sit.placementcell.app.repository;

import com.sit.placementcell.app.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    List<Student> findAllByDepartmentIgnoreCase(String department);

    List<Student> findAllByPlacementWillingIgnoreCase(String placementWilling);

    Optional<Student> findByRollNo(String rollNo);

}
