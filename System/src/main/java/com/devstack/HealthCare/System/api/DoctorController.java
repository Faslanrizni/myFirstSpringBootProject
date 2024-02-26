package com.devstack.HealthCare.System.api;

import com.devstack.HealthCare.System.dto.request.RequestDoctorDto;
import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/doctors")/*doctores wala s akura ona*/
public class DoctorController {
    @PostMapping
    public String  createDoctor(@RequestBody RequestDoctorDto doctorDto  ){
        return doctorDto.toString();
    }



    @GetMapping("/{id}")
    public String  findDoctor(@PathVariable String id){
        return id+"";
    }

    /*localhost:8000/api/v1/doctors?id=S-HC-D-1*/
    @PutMapping(params = "id")
    public String  updateDoctor(
            @RequestParam String id,
            @RequestBody RequestDoctorDto doctorDto ){
        return doctorDto.toString()
                ;
    }

    /*localhost:8000/api/v1/doctors/S-HC-D-1*/
    @DeleteMapping("/{id}") /*we putting curly brackets here because of path variable*/
    public String  deleteDoctor(@PathVariable String id){
        return "deleteDoctor";
    }

    /*localhost:8000/api/v1/doctors/list?searchText=Nimal&page=0&size=10*/
    @GetMapping(path = "/list",params = {"searchText","page","size"}) /*if we didnnt pu t path error will occure3 that tell get method has duplicate*/
    public String  findAllDoctor(
            @RequestParam String searchText,
            @RequestParam int page,
            @RequestParam int size
    ){


        return "createDoctor";
    }

}
