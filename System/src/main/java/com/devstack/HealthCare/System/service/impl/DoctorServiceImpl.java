package com.devstack.HealthCare.System.service.impl;

import com.devstack.HealthCare.System.dto.request.RequestDoctorDto;
import com.devstack.HealthCare.System.dto.response.ResponseDoctorDto;
import com.devstack.HealthCare.System.dto.response.paginated.PaginatedDoctorResponseDto;
import com.devstack.HealthCare.System.entity.Doctor;
import com.devstack.HealthCare.System.repo.DoctorRepo;
import com.devstack.HealthCare.System.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepo doctorRepo;


    @Autowired /*injecting*/
    public DoctorServiceImpl(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    @Override
    public void createDoctor(RequestDoctorDto dto) {
        UUID uuid = UUID.randomUUID();
        long docId = uuid.getMostSignificantBits();

        Doctor doctor = new Doctor(
            docId,
                dto.getName(),
                dto.getAddress(),
                dto.getContact(),
                dto.getSalary()
        );
        doctorRepo.save(doctor);

    }

    @Override
    public ResponseDoctorDto getDoctor(long id) {
        Optional<Doctor> selectedDoctor = doctorRepo.findById(id);
        if(selectedDoctor.isEmpty()){
            throw new RuntimeException("Doctor not found");
        }

        Doctor doc = selectedDoctor.get();
        return new ResponseDoctorDto(
                doc.getId(),doc.getName(),
                doc.getAddress(),doc.getContact(),doc.getSalary()
        ){


        };
    }

    @Override
    public void deleteDoctor(long id) {
        Optional<Doctor> selectedDoctor = doctorRepo.findById(id);
        if(selectedDoctor.isPresent()){
            throw new RuntimeException("Doctor nit found");
        }

       doctorRepo.deleteById(selectedDoctor.get().getId());
    }

    @Override
    public List<ResponseDoctorDto> findDoctorsByName(String name) {
        List<Doctor> allByName = doctorRepo.findAllByName(name);
        return null;
    }

    @Override
    public void updateDoctor(long id, RequestDoctorDto dto) {
        Optional<Doctor> selectedDoctor = doctorRepo.findById(id);
        if(selectedDoctor.isPresent()){
            throw new RuntimeException("Doctor nit found");
        }
        Doctor doc = selectedDoctor.get();
        doc.setName(dto.getName());
        doc.setAddress(dto.getAddress());
        doc.setSalary(dto.getSalary());
        doc.setContact(dto.getContact());
        doctorRepo.save(doc);


    }

    @Override
    public PaginatedDoctorResponseDto getAllDoctor(String searchText, int page, int size) {
        searchText= "%"+searchText+"%";
        List<Doctor> doctors = doctorRepo.searchDoctors(searchText, (Pageable) PageRequest.of(page, size));
        long doctorCount  = doctorRepo.countDoctors(searchText);
        List<ResponseDoctorDto> dtos =new ArrayList<>();
        doctors.forEach(doc ->{
            dtos.add(
                    new ResponseDoctorDto(
                            doc.getId(),doc.getName(),
                            doc.getAddress(),doc.getContact(),doc.getSalary()
                    )
            );
        });
        return new PaginatedDoctorResponseDto(
                doctorCount,
                dtos
        );
    }
}
