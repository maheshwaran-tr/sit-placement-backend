package com.sit.placementcell.app.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguraton {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutHandler logoutHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        req -> req
                                .requestMatchers("/sit/auth/**")
                                .permitAll()

                                .requestMatchers(GET, UrlFor.allStudents).permitAll()
                                .requestMatchers(POST,UrlFor.addStudents).permitAll()
                                .requestMatchers(PUT,UrlFor.updateStudents).permitAll()
                                .requestMatchers(DELETE,UrlFor.deleteStudents).permitAll()
                                .requestMatchers(GET,UrlFor.studentByToken).permitAll()
                                .requestMatchers(GET,UrlFor.studentsByDept).permitAll()
                                .requestMatchers(GET,UrlFor.studentFilter).permitAll()
                                .requestMatchers(GET,UrlFor.studentsByPlacementWilling).permitAll()
                                .requestMatchers(POST,UrlFor.applyJob).permitAll()
                                .requestMatchers(PUT,UrlFor.updatePlacementWilling).permitAll()
                                .requestMatchers(POST,"sit/students/filter").permitAll()
                                .requestMatchers(GET,UrlFor.allAppliedJobs).permitAll()

                                .requestMatchers(GET,UrlFor.allStaffs).permitAll()
                                .requestMatchers(POST,UrlFor.addStaffs).permitAll()
                                .requestMatchers(PUT,UrlFor.updateStaffs).permitAll()
                                .requestMatchers(DELETE,UrlFor.deleteStaffs).permitAll()
                                .requestMatchers(GET,UrlFor.staffByToken).permitAll()
                                .requestMatchers(POST,UrlFor.approveAppliedStudents).permitAll()

                                .requestMatchers(GET,UrlFor.getApprovedStudentsAdmin).permitAll()
                                .requestMatchers(GET,UrlFor.getAllApplicationsAdmin).permitAll()

                                .requestMatchers(GET,UrlFor.allJobs).permitAll()
                                .requestMatchers(POST,UrlFor.addJobs).permitAll()
                                .requestMatchers(PUT,UrlFor.updateJobs).permitAll()
                                .requestMatchers(DELETE,UrlFor.deleteJobs).permitAll()


                                .anyRequest()
                                .authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .logout(logout ->
                        logout.logoutUrl("/sit/auth/logout")
                                .addLogoutHandler(logoutHandler)
                                .logoutSuccessHandler(((request, response, authentication) -> SecurityContextHolder.clearContext())
                                ));
        return http.build();
    }
}
