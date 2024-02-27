package com.ins.clinique.services;

import com.ins.clinique.entities.dtos.TechnicienDto;

import java.util.List;

public interface TechnicienService {
    List<TechnicienDto> getAllTechniciens();
    TechnicienDto getTechnicienByID(int id);
    TechnicienDto updateTechnicien(int id, TechnicienDto dto);
    TechnicienDto saveTechnicien(TechnicienDto dto);
}
