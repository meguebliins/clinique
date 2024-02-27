package com.ins.clinique.services;

import com.ins.clinique.entities.dtos.ConsultationDto;
import com.ins.clinique.entities.dtos.InsertConsultationDto;

import java.time.LocalDateTime;
import java.util.List;

public interface ConsultationService {
    List<ConsultationDto> getAllConsultations();
    ConsultationDto getConsultationByID(int id);
    ConsultationDto getConsultationByStartDate(LocalDateTime startDate);
    ConsultationDto updateConsultation(int id, ConsultationDto dto);
    void saveConsultation(InsertConsultationDto dto);
}
