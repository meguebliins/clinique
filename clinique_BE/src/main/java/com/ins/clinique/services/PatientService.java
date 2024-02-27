package com.ins.clinique.services;

import com.ins.clinique.entities.dtos.PatientDto;

import java.util.List;

public interface PatientService {
    List<PatientDto> getAllPatients();
    PatientDto getPatientByID(int id);

    PatientDto updatePatient(int id, PatientDto dto);
    PatientDto savePatient(PatientDto dto);
}
