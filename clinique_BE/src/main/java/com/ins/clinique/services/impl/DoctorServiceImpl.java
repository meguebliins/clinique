package com.ins.clinique.services.impl;

import com.ins.clinique.entities.Doctor;
import com.ins.clinique.entities.dtos.DoctorDto;
import com.ins.clinique.entities.mappers.DoctorMapper;
import com.ins.clinique.entities.mappers.EntrepriseMapper;
import com.ins.clinique.repositories.EntrepriseRepository;
import com.ins.clinique.repositories.DoctorRepository;
import com.ins.clinique.services.DoctorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    private DoctorRepository doctorRepository;
    private EntrepriseRepository entrepriseRepository;

    private DoctorMapper doctorMapper;

    public DoctorServiceImpl(DoctorRepository doctorRepository, DoctorMapper doctorMapper, EntrepriseMapper entrepriseMapper, EntrepriseRepository entrepriseRepository) {
        this.doctorRepository = doctorRepository;
        this.doctorMapper = doctorMapper;
        this.entrepriseRepository = entrepriseRepository;
    }
    DoctorDto toDto(Doctor doctor){

         return doctorMapper.fromEntity(doctor);
    }
    Doctor fromDto(DoctorDto dto){

        return doctorMapper.toEntity(dto);
    }

    @Override
    public List<DoctorDto> getAllDoctors() {
        return doctorRepository.findAll()
                .stream()
                .map(
                        this::toDto
                )
                .toList();
    }

    @Override
    public DoctorDto getDoctorByID(int id) {
        return toDto(doctorRepository.findById( id).get());
    }

//    @Override
//    public DoctorDto getDoctorByCode(String code) {
//        return toDto(doctorRepository.findByCode(code));
//    }

    @Override
    public DoctorDto updateDoctor(int id, DoctorDto dto) {
        if(! doctorRepository.existsById(id)){
            return null;
        }
        return toDto(doctorRepository.save(fromDto(dto)));
    }

    @Override
    public DoctorDto saveDoctor(DoctorDto dto) {
        if (entrepriseRepository.findById(dto.getEntrepriseID())==null){
            return null;
        }else{

            Doctor saveDoc=fromDto(dto);
            return toDto(doctorRepository.save(saveDoc));
        }

    }

    @Override
    public void deleteDoctor(int id) {
        doctorRepository.deleteById(id);
    }
}
