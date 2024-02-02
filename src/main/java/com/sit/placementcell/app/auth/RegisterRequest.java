package com.sit.placementcell.app.auth;

import com.sit.placementcell.app.entity.Admin;
import com.sit.placementcell.app.entity.Staff;
import com.sit.placementcell.app.entity.Student;
import com.sit.placementcell.app.user.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String username;
    private String email;
    private String password;
    private Role role;

    private Student student;
    private Staff staff;
    private Admin admin;
}