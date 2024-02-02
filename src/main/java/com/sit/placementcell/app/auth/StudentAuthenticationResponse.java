package com.sit.placementcell.app.auth;

import com.sit.placementcell.app.entity.Student;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentAuthenticationResponse extends AuthenticationResponse{

    private Student student;

    public StudentAuthenticationResponse(String accessToken, String refreshToken, Student student) {
        super(accessToken, refreshToken);
        this.student = student;
    }
}
