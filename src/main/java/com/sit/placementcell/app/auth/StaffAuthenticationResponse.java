package com.sit.placementcell.app.auth;

import com.sit.placementcell.app.entity.Staff;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StaffAuthenticationResponse extends AuthenticationResponse{
    private Staff staff;

    public StaffAuthenticationResponse(String accessToken, String refreshToken, Staff staff) {
        super(accessToken, refreshToken);
        this.staff = staff;
    }
}
