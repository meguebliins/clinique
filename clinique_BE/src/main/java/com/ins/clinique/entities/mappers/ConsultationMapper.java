package com.ins.clinique.entities.mappers;


import com.ins.clinique.entities.Consultation;
import com.ins.clinique.entities.dtos.ConsultationDto;
import com.ins.clinique.entities.dtos.EntrepriseDto;
import com.ins.clinique.entities.dtos.InsertConsultationDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ConsultationMapper {
    ConsultationMapper CONSULTATION_MAPPER = Mappers.getMapper(ConsultationMapper.class);
    @Mapping(source = "appointmentDto",target ="appointment" )
    Consultation fromDto(ConsultationDto dto);
   // @Mapping(source = "appointmentDto",target ="appointment" )
    Consultation fromDtoInsert(InsertConsultationDto dto);
    @Mapping(source = "appointment",target ="appointmentDto" )
    ConsultationDto toDto(Consultation consultation);

}
