package com.ins.clinique.controllers;

import com.ins.clinique.controllers.apis.ConsultationApi;
import com.ins.clinique.entities.dtos.ConsultationDto;
import com.ins.clinique.entities.dtos.InsertConsultationDto;
import com.ins.clinique.services.ConsultationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@Slf4j
public class ConsultationController implements ConsultationApi {
    private ConsultationService consultationService;

    public ConsultationController(ConsultationService consultationService) {
        this.consultationService = consultationService;
    }

    @Override
    public List<ConsultationDto> getAllConsultations() {
        return consultationService.getAllConsultations();
    }

    @Override
    public ConsultationDto getConsultationByID(int id) {
        return consultationService.getConsultationByID(id);
    }

    @Override
    public ConsultationDto getConsultationByStartDate(LocalDateTime startDate) {
        return consultationService.getConsultationByStartDate(startDate);
    }

    @Override
    public ConsultationDto updateConsultation(int id, ConsultationDto dto) {
        return consultationService.updateConsultation(id, dto);
    }

    @Override
    public void saveConsultation(InsertConsultationDto dto) {
         consultationService.saveConsultation(dto);
    }
}
