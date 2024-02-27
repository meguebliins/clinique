package com.ins.clinique.services.impl;

import com.ins.clinique.entities.Patient;
import com.ins.clinique.entities.dtos.PatientDto;
import com.ins.clinique.entities.mappers.EntrepriseMapper;
import com.ins.clinique.entities.mappers.PatientMapper;
import com.ins.clinique.repositories.EntrepriseRepository;
import com.ins.clinique.repositories.PatientRepository;
import com.ins.clinique.services.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    private PatientRepository patientRepository;
    private EntrepriseRepository entrepriseRepository;

    private PatientMapper patientMapper;

    public PatientServiceImpl(PatientRepository patientRepository, PatientMapper patientMapper, EntrepriseMapper entrepriseMapper, EntrepriseRepository entrepriseRepository) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
        this.entrepriseRepository = entrepriseRepository;
    }
    PatientDto toDto(Patient patient){
        return patientMapper.toDto(patient);
    }
    Patient fromDto(PatientDto dto){

        return patientMapper.fromDto(dto);
    }

    @Override
    public List<PatientDto> getAllPatients() {
        return patientRepository.findAll()
                .stream()
                .map(
                        this::toDto
                )
                .toList();
    }

    @Override
    public PatientDto getPatientByID(int id) {
        return toDto(patientRepository.findById( id).get());
    }



    @Override
    public PatientDto updatePatient(int id, PatientDto dto) {
        if(! patientRepository.existsById(id)){
            return null;
        }
        return toDto(patientRepository.save(fromDto(dto)));
    }

    @Override
    public PatientDto savePatient(PatientDto dto) {
        if (entrepriseRepository.findById(dto.getId())==null){
            return null;
        }else{

            return toDto(patientRepository.save(fromDto(dto)));
        }

    }
}
