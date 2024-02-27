package com.ins.clinique.services;

import com.ins.clinique.entities.Doctor;
import com.ins.clinique.entities.dtos.DoctorDto;
import com.ins.clinique.entities.dtos.DoctorDto;

import java.util.List;

public interface DoctorService {
    List<DoctorDto> getAllDoctors();
    DoctorDto getDoctorByID(int id);
//    DoctorDto getDoctorByCode(String code);
    DoctorDto updateDoctor(int id, DoctorDto dto);
    DoctorDto saveDoctor(DoctorDto dto);
    void deleteDoctor( int id);
}
