package com.devstack.HealthCare.System.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/doctors")/*doctores wala s akura ona*/
public class DoctorController {
    @PostMapping
    public String  createDoctor(){
        return "createDoctor";
    }

    @GetMapping
    public String  findDoctor(){
        return "findDoctor";
    }

    @PutMapping
    public String  updateDoctor(){
        return "updateDoctor";
    }

    @DeleteMapping
    public String  deleteDoctor(){
        return "deleteDoctor";
    }

    @GetMapping(path = "/list") /*if we didnnt pu t path error will occure3 that tell get method has duplicate*/
    public String  findAllDoctor(){
        return "createDoctor";
    }

}
