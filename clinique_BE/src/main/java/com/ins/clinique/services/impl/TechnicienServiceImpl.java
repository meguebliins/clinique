package com.ins.clinique.services.impl;

import com.ins.clinique.entities.Technicien;
import com.ins.clinique.entities.dtos.TechnicienDto;
import com.ins.clinique.entities.mappers.TechnicienMapper;
import com.ins.clinique.entities.mappers.EntrepriseMapper;
import com.ins.clinique.repositories.TechnicienRepository;
import com.ins.clinique.repositories.EntrepriseRepository;
import com.ins.clinique.services.TechnicienService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicienServiceImpl implements TechnicienService {
    private TechnicienRepository technicienRepository;
    private EntrepriseRepository entrepriseRepository;

    private TechnicienMapper technicienMapper;

    public TechnicienServiceImpl(TechnicienRepository technicienRepository, TechnicienMapper technicienMapper, EntrepriseMapper entrepriseMapper, EntrepriseRepository entrepriseRepository) {
        this.technicienRepository = technicienRepository;
        this.technicienMapper = technicienMapper;
        this.entrepriseRepository = entrepriseRepository;
    }
    TechnicienDto toDto(Technicien technicien){
        return technicienMapper.toDto(technicien);
    }
    Technicien fromDto(TechnicienDto dto){

        return technicienMapper.fromDto(dto);
    }

    @Override
    public List<TechnicienDto> getAllTechniciens() {
        return technicienRepository.findAll()
                .stream()
                .map(
                        this::toDto
                )
                .toList();
    }

    @Override
    public TechnicienDto getTechnicienByID(int id) {
        return toDto(technicienRepository.findById( id).get());
    }
    @Override
    public TechnicienDto updateTechnicien(int id, TechnicienDto dto) {
        if(! technicienRepository.existsById(id)){
            return null;
        }
        return toDto(technicienRepository.save(fromDto(dto)));
    }

    @Override
    public TechnicienDto saveTechnicien(TechnicienDto dto) {
        if (entrepriseRepository.findById(dto.getId())==null){
            return null;
        }else{
            return toDto(technicienRepository.save(fromDto(dto)));
        }

    }
}
