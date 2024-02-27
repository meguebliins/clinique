package com.ins.clinique.entities.mappers;

import com.ins.clinique.entities.Entreprise;
import com.ins.clinique.entities.dtos.EntrepriseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EntrepriseMapper {
    EntrepriseMapper ENTREPRISE_MAPPER= Mappers.getMapper(EntrepriseMapper.class);

    Entreprise toEntity(EntrepriseDto entrepriseDto);
//    @Mapping(source = "", target = "")
    EntrepriseDto fromEntity(Entreprise entreprise);
}
