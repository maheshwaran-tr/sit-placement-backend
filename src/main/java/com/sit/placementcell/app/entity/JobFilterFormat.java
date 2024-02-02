package com.sit.placementcell.app.entity;


import lombok.Data;

@Data
public class JobFilterFormat {
    private Integer jobId;
    private Integer studentId;
    private Integer statusId;
    private String dept;
}
