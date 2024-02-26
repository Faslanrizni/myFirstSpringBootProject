package com.devstack.HealthCare.System.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

@Data
public class ResponseDoctorDto {

    private long id;
    private String name;
    private String address;
    private String contact;
    private double salary;
}
