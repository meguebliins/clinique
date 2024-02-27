package com.ins.clinique.services;

import com.ins.clinique.entities.dtos.MedicalActDto;

import java.util.List;

public interface MedicalActService {
    List<MedicalActDto> getAllMedicalActs();
    MedicalActDto getMedicalActByID(int id);
    MedicalActDto updateMedicalAct(int id, MedicalActDto dto);
    MedicalActDto saveMedicalAct(MedicalActDto dto);
}
