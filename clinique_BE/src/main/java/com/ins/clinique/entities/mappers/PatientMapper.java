package com.ins.clinique.entities.mappers;

import com.ins.clinique.entities.Patient;
import com.ins.clinique.entities.dtos.PatientDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    PatientMapper PATIENT_MAPPER = Mappers.getMapper(PatientMapper.class);

    Patient fromDto(
            PatientDto dto);

    PatientDto toDto(Patient patient);

}
