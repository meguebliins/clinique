package com.ins.clinique.controllers.apis;

import com.ins.clinique.entities.dtos.PatientDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("patient")
@CrossOrigin(origins  = "http://localhost:4200/")
public interface PatientApi {
    @GetMapping("/all")
    List<PatientDto> getAllPatients();
    @GetMapping("/{id}")
    PatientDto getPatientByID(@PathVariable int id);
    @PutMapping("/{id}")
    PatientDto updatePatient(@PathVariable int id, @RequestBody PatientDto dto);
    @PostMapping
    PatientDto savePatient(@RequestBody PatientDto dto);
}
