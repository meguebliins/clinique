package com.ins.clinique.controllers.apis;

import com.ins.clinique.entities.dtos.MedicalActDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("medicalAct")
public interface MedicalActApi {
    @GetMapping("/all")
    List<MedicalActDto> getAllMedicalActs();
    @GetMapping("/{id}")
    MedicalActDto getMedicalActByID(@PathVariable int id);
    @PutMapping("/{id}")
    MedicalActDto updateMedicalAct(@PathVariable int id, @RequestBody MedicalActDto dto);
    @PostMapping
    MedicalActDto saveMedicalAct(@RequestBody MedicalActDto dto);
}
