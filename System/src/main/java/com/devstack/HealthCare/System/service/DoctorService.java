package com.devstack.HealthCare.System.service;

import com.devstack.HealthCare.System.dto.request.RequestDoctorDto;
import com.devstack.HealthCare.System.dto.response.ResponseDoctorDto;
import com.devstack.HealthCare.System.dto.response.paginated.PaginatedDoctorResponseDto;

import java.util.List;

public interface DoctorService {

    public void createDoctor(RequestDoctorDto dto);
    public ResponseDoctorDto getDoctor(long id);
    public void deleteDoctor(long id);
    public List<ResponseDoctorDto> findDoctorsByName(String name);
    public void updateDoctor(long id, RequestDoctorDto dto);
    public PaginatedDoctorResponseDto getAllDoctor(String searchText, int page, int size);
}
