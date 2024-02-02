package com.sit.placementcell.app.auth;

import com.sit.placementcell.app.entity.Admin;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminAuthenticationResponse extends AuthenticationResponse{
    private Admin admin;

    public AdminAuthenticationResponse(String accessToken, String refreshToken, Admin admin) {
        super(accessToken, refreshToken);
        this.admin = admin;
    }
}
