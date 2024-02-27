package com.ins.clinique.services.impl;

import com.ins.clinique.entities.MedicalAct;
import com.ins.clinique.entities.dtos.MedicalActDto;
import com.ins.clinique.entities.mappers.MedicalActMapper;
import com.ins.clinique.entities.mappers.EntrepriseMapper;
import com.ins.clinique.repositories.MedicalActRepository;
import com.ins.clinique.repositories.EntrepriseRepository;
import com.ins.clinique.services.MedicalActService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalActServiceImpl implements MedicalActService {
    private MedicalActRepository medicalActRepository;
    private EntrepriseRepository entrepriseRepository;

    private MedicalActMapper medicalActMapper;

    public MedicalActServiceImpl(MedicalActRepository medicalActRepository, MedicalActMapper medicalActMapper, EntrepriseMapper entrepriseMapper, EntrepriseRepository entrepriseRepository) {
        this.medicalActRepository = medicalActRepository;
        this.medicalActMapper = medicalActMapper;
        this.entrepriseRepository = entrepriseRepository;
    }
    MedicalActDto toDto(MedicalAct medicalAct){
        return medicalActMapper.toDto(medicalAct);
    }
    MedicalAct fromDto(MedicalActDto dto){

        return medicalActMapper.fromDto(dto);
    }

    @Override
    public List<MedicalActDto> getAllMedicalActs() {
        return medicalActRepository.findAll()
                .stream()
                .map(
                        this::toDto
                )
                .toList();
    }

    @Override
    public MedicalActDto getMedicalActByID(int id) {
        return toDto(medicalActRepository.findById( id).get());
    }



    @Override
    public MedicalActDto updateMedicalAct(int id, MedicalActDto dto) {
        if(! medicalActRepository.existsById(id)){
            return null;
        }
        return toDto(medicalActRepository.save(fromDto(dto)));
    }

    @Override
    public MedicalActDto saveMedicalAct(MedicalActDto dto) {
        if (entrepriseRepository.findById(dto.getEntrepriseId())==null){
            return null;
        }else{
            return toDto(medicalActRepository.save(fromDto(dto)));
        }

    }
}
