package com.ins.clinique.entities.mappers;

import com.ins.clinique.entities.Doctor;
import com.ins.clinique.entities.dtos.DoctorDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    DoctorMapper DOCTOR_MAPPER= Mappers.getMapper(DoctorMapper.class);

    Doctor toEntity(DoctorDto doctorDto);
//    @Mapping(source = "", target = "")
DoctorDto fromEntity (Doctor doctor);
}
