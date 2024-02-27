package com.ins.clinique.entities.mappers;

import com.ins.clinique.entities.MedicalAct;
import com.ins.clinique.entities.dtos.MedicalActDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MedicalActMapper {
    MedicalActMapper MEDICAL_ACT_MAPPER = Mappers.getMapper(MedicalActMapper.class);

    MedicalAct fromDto(MedicalActDto dto);

    MedicalActDto toDto(MedicalAct patient);

}
