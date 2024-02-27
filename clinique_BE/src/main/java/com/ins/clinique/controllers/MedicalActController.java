package com.ins.clinique.controllers;

import com.ins.clinique.controllers.apis.MedicalActApi;
import com.ins.clinique.entities.dtos.MedicalActDto;
import com.ins.clinique.services.MedicalActService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class MedicalActController implements MedicalActApi {
    private MedicalActService medicalActService;

    public MedicalActController(MedicalActService medicalActService) {
        this.medicalActService = medicalActService;
    }

    @Override
    public List<MedicalActDto> getAllMedicalActs() {
        return medicalActService.getAllMedicalActs();
    }

    @Override
    public MedicalActDto getMedicalActByID(int id) {
        return medicalActService.getMedicalActByID(id);
    }



    @Override
    public MedicalActDto updateMedicalAct(int id, MedicalActDto dto) {
        return medicalActService.updateMedicalAct(id, dto);
    }

    @Override
    public MedicalActDto saveMedicalAct(MedicalActDto dto) {
        return medicalActService.saveMedicalAct(dto);
    }
}
