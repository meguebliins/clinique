package com.ins.clinique.controllers;

import com.ins.clinique.controllers.apis.EntrepriseAPI;
import com.ins.clinique.entities.dtos.EntrepriseDto;
import com.ins.clinique.services.EntrepriseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class EntrepriseController implements EntrepriseAPI {
    private EntrepriseService entrepriseService;

    public EntrepriseController(EntrepriseService entrepriseService) {
        this.entrepriseService = entrepriseService;
    }

    @Override
    public List<EntrepriseDto> getAllEntreprise() {
        return entrepriseService.getAllEntreprise();
    }

    @Override
    public EntrepriseDto getEntrepriseById(int id) {
        return entrepriseService.getEntrepriseById(id);
    }

    @Override
    public EntrepriseDto saveEntreprise(EntrepriseDto dto) {
        return entrepriseService.saveEntreprise(dto);
    }

    @Override
    public EntrepriseDto updateEntreprise(int id, EntrepriseDto dto) {
        return entrepriseService.updateEntreprise(id, dto);
    }
}
