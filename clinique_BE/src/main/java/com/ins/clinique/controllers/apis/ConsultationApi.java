package com.ins.clinique.controllers.apis;

import com.ins.clinique.entities.dtos.ConsultationDto;
import com.ins.clinique.entities.dtos.InsertConsultationDto;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("consultation")
public interface ConsultationApi {
    @GetMapping("/all")
    List<ConsultationDto> getAllConsultations();
    @GetMapping("/{id}")
    ConsultationDto getConsultationByID(@PathVariable int id);
    @GetMapping
    ConsultationDto getConsultationByStartDate(@RequestParam LocalDateTime startDate);
    @PutMapping("/{id}")
    ConsultationDto updateConsultation(@PathVariable int id, @RequestBody ConsultationDto dto);
    @PostMapping
    void saveConsultation(@RequestBody InsertConsultationDto dto);
}
