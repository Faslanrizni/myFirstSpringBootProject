package com.devstack.HealthCare.System.dto.request;


import lombok.*;

@Getter
@Setter
/*@AllArgsConstructor
@NoArgsConstructor
@ToString*/
@Data /*to oya 3ma wenuwata*/
public class RequestDoctorDto {

    private String name;
    private String address;
    private String contact;
    private double salary;


}
