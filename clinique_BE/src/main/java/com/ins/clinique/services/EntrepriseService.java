package com.ins.clinique.services;

import com.ins.clinique.entities.dtos.EntrepriseDto;

import java.util.List;

public interface EntrepriseService {
    List<EntrepriseDto> getAllEntreprise();
    EntrepriseDto getEntrepriseById(int id);
    EntrepriseDto saveEntreprise(EntrepriseDto dto);
    EntrepriseDto updateEntreprise(int id, EntrepriseDto dto);
}
