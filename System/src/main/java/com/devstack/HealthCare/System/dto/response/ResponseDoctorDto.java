package com.devstack.HealthCare.System.dto.response;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor

@Data
public class ResponseDoctorDto {

    private long id;
    private String name;
    private String address;
    private String contact;
    private double salary;
}
