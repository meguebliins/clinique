package com.ins.clinique.services.impl;

import com.ins.clinique.entities.Entreprise;
import com.ins.clinique.entities.dtos.EntrepriseDto;
import com.ins.clinique.entities.mappers.EntrepriseMapper;
import com.ins.clinique.repositories.EntrepriseRepository;
import com.ins.clinique.services.EntrepriseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService {
    private EntrepriseRepository entrepriseRepository;
    private EntrepriseMapper entrepriseMapper;

    public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository, EntrepriseMapper entrepriseMapper) {
        this.entrepriseRepository = entrepriseRepository;
        this.entrepriseMapper = entrepriseMapper;
    }
    public EntrepriseDto toDto(Entreprise entreprise){
       return entrepriseMapper.fromEntity(entreprise);
    }
    public Entreprise toEntity(EntrepriseDto dto){
        return entrepriseMapper.toEntity(dto);
    }
    @Override
    public List<EntrepriseDto> getAllEntreprise() {
        return entrepriseRepository
                .findAll()
                .stream()
                .map(
                        this::toDto
                )
                .toList();
    }

    @Override
    public EntrepriseDto getEntrepriseById(int id) {
        return toDto(entrepriseRepository.findById(id).get());
    }

    @Override
    public EntrepriseDto saveEntreprise(EntrepriseDto dto) {
        return toDto(entrepriseRepository.save(toEntity(dto)));
    }

    @Override
    public EntrepriseDto updateEntreprise(int id, EntrepriseDto dto) {
        if(!entrepriseRepository.existsById(id)){
            return  null;
        }
        return toDto(entrepriseRepository.save(toEntity(dto)));
    }
}
