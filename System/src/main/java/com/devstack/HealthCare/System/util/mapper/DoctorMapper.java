package com.devstack.HealthCare.System.util.mapper;

import com.devstack.HealthCare.System.dto.request.RequestDoctorDto;
import com.devstack.HealthCare.System.dto.response.ResponseDoctorDto;
import com.devstack.HealthCare.System.entity.Doctor;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    ResponseDoctorDto toResponseDoctorDto(Doctor doctor); /*entity to Dto*/
    Doctor toDoctor(RequestDoctorDto dto); /*dto to entity*/

    List<ResponseDoctorDto> toResponseDoctorDtoList(List<Doctor> list);
}
