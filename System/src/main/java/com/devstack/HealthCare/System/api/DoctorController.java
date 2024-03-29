package com.devstack.HealthCare.System.api;

import com.devstack.HealthCare.System.dto.request.RequestDoctorDto;
import com.devstack.HealthCare.System.service.DoctorService;
import com.devstack.HealthCare.System.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/doctors")/*doctores wala s akura ona*/
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public ResponseEntity<StandardResponse> createDoctor(@RequestBody RequestDoctorDto doctorDto  ){
        doctorService.createDoctor(doctorDto);
        return new ResponseEntity<>(
                new StandardResponse(201,"doctor saved",doctorDto.getName()),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse>  findDoctor(@PathVariable long id){
        return new ResponseEntity<>(
                new StandardResponse(200,"doctor data",doctorService.getDoctor(id)),
                HttpStatus.OK
        );
    }

    /*localhost:8000/api/v1/doctors?id=S-HC-D-1*/
    @PutMapping(params = "id")
    public ResponseEntity<StandardResponse> updateDoctor(
            @RequestParam long id,
            @RequestBody RequestDoctorDto doctorDto
    ){
        doctorService.updateDoctor(id,doctorDto);
        return new ResponseEntity<>(
                new StandardResponse(201,"update data!",doctorDto.getName()),
                HttpStatus.CREATED
        );
    }

    /*localhost:8000/api/v1/doctors/S-HC-D-1*/
    @DeleteMapping("/{id}") /*we putting curly brackets here because of path variable*/
    public ResponseEntity<StandardResponse>  deleteDoctor(@PathVariable long id){
        doctorService.deleteDoctor(id);
        return new ResponseEntity<>(
                new StandardResponse(204,"deleted data",id),
                HttpStatus.NO_CONTENT
        );
    }

    /*localhost:8000/api/v1/doctors/list?searchText=Nimal&page=0&size=10*/
    @GetMapping(path = "/list",params = {"searchText","page","size"}) /*if we didnnt pu t path error will occure3 that tell get method has duplicate*/
    public ResponseEntity<StandardResponse>  findAllDoctor(
            @RequestParam String searchText,
            @RequestParam int page,
            @RequestParam int size
    ){


        return new ResponseEntity<>(
                new StandardResponse(204,"deleted data",doctorService.getAllDoctor(
                        searchText,page,size
                )),
                HttpStatus.OK
        );
    }

}
