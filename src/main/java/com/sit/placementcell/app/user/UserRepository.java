package com.sit.placementcell.app.user;

import com.sit.placementcell.app.entity.Admin;
import com.sit.placementcell.app.entity.Staff;
import com.sit.placementcell.app.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByUsername(String username);

    void deleteByUsername(String username);

    Optional<User> findByStaff(Staff staff);
    Optional<User> findByStudent(Student student);
    Optional<User> findByAdmin(Admin admin);
}