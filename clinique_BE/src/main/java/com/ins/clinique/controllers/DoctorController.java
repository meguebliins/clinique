package com.ins.clinique.controllers;

import com.ins.clinique.controllers.apis.DoctorApi;
import com.ins.clinique.entities.dtos.DoctorDto;
import com.ins.clinique.services.DoctorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class DoctorController implements DoctorApi {
    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @Override
    public List<DoctorDto> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @Override
    public DoctorDto getDoctorByID(int id) {
        return doctorService.getDoctorByID(id);
    }

//    @Override
//    public DoctorDto getDoctorByCode(String code) {
//        return doctorService.getDoctorByCode(code);
//    }

    @Override
    public DoctorDto updateDoctor(int id, DoctorDto dto) {
        return doctorService.updateDoctor(id, dto);
    }

    @Override
    public DoctorDto saveDoctor(DoctorDto dto) {
        return doctorService.saveDoctor(dto);
    }

    @Override
    public void deleteDoctor(int id) {
        doctorService.deleteDoctor(id);
    }
}
