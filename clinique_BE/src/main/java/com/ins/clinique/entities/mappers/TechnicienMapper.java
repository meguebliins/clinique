package com.ins.clinique.entities.mappers;

import com.ins.clinique.entities.Technicien;
import com.ins.clinique.entities.dtos.TechnicienDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TechnicienMapper {
    TechnicienMapper TECHNICIEN_MAPPER = Mappers.getMapper(TechnicienMapper.class);

    Technicien fromDto(TechnicienDto dto);

    TechnicienDto toDto(Technicien doctor);

}
