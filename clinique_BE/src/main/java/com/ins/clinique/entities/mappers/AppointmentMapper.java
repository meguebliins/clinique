package com.ins.clinique.entities.mappers;

import com.ins.clinique.entities.Appointment;
import com.ins.clinique.entities.dtos.AppointmentDto;
import com.ins.clinique.entities.dtos.InsertAppointmentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {
    AppointmentMapper APPOINTMENT_MAPPER = Mappers.getMapper(AppointmentMapper.class);
    @Mapping(source = "doctorDto",target = "doctor" )
//    @Mapping(source = "patientDto",target ="patient" )
//    @Mapping(source = "technicienDto",target ="technicien" )
//    @Mapping(source = "medicalActDto",target ="medicalAct" )
    Appointment fromDto(AppointmentDto dto);
    Appointment fromDtoInsert(InsertAppointmentDto dto);
    @Mapping(source = "doctor",target ="doctorDto" )
//    @Mapping(source = "patient",target ="patientDto" )
//    @Mapping(source = "technicien",target ="technicienDto" )
//    @Mapping(source = "medicalAct",target ="medicalActDto" )
    AppointmentDto toDto(Appointment appointment);

}
