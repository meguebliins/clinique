package com.ins.clinique.controllers.apis;

import com.ins.clinique.entities.dtos.DoctorDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins  = "http://localhost:4200/")
@RequestMapping("doctor")

public interface DoctorApi {
    @GetMapping("/all")
    List<DoctorDto> getAllDoctors();
    @GetMapping("/{id}")
    DoctorDto getDoctorByID(@PathVariable int id);
//    @GetMapping
//    DoctorDto getDoctorByCode(@RequestParam String code);
    @PutMapping("/{id}")
    DoctorDto updateDoctor(@PathVariable int id, @RequestBody DoctorDto dto);
    @PostMapping
    DoctorDto saveDoctor(@RequestBody DoctorDto dto);
    @DeleteMapping("/{id}")
    void deleteDoctor( @PathVariable int id);
}
