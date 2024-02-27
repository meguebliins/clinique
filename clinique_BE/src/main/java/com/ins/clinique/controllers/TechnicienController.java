package com.ins.clinique.controllers;

import com.ins.clinique.controllers.apis.TechnicienApi;
import com.ins.clinique.entities.dtos.TechnicienDto;
import com.ins.clinique.services.TechnicienService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class TechnicienController implements TechnicienApi {
    private TechnicienService technicienService;

    public TechnicienController(TechnicienService technicienService) {
        this.technicienService = technicienService;
    }

    @Override
    public List<TechnicienDto> getAllTechniciens() {
        return technicienService.getAllTechniciens();
    }

    @Override
    public TechnicienDto getTechnicienByID(int id) {
        return technicienService.getTechnicienByID(id);
    }

    @Override
    public TechnicienDto updateTechnicien(int id, TechnicienDto dto) {
        return technicienService.updateTechnicien(id, dto);
    }

    @Override
    public TechnicienDto saveTechnicien(TechnicienDto dto) {
        return technicienService.saveTechnicien(dto);
    }
}
