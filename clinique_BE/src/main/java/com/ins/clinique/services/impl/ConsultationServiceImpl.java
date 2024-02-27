package com.ins.clinique.services.impl;

import com.ins.clinique.entities.Appointment;
import com.ins.clinique.entities.Consultation;
import com.ins.clinique.entities.dtos.AppointmentDto;
import com.ins.clinique.entities.dtos.ConsultationDto;
import com.ins.clinique.entities.dtos.EntrepriseDto;
import com.ins.clinique.entities.dtos.InsertConsultationDto;
import com.ins.clinique.entities.mappers.AppointmentMapper;
import com.ins.clinique.entities.mappers.ConsultationMapper;
import com.ins.clinique.entities.mappers.EntrepriseMapper;
import com.ins.clinique.repositories.AppointmentRepository;
import com.ins.clinique.repositories.ConsultationRepository;
import com.ins.clinique.repositories.EntrepriseRepository;
import com.ins.clinique.services.ConsultationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class ConsultationServiceImpl implements ConsultationService {
    private ConsultationRepository consultationRepository;
    private EntrepriseRepository entrepriseRepository;
    private ConsultationMapper consultationMapper;
    private AppointmentRepository appointmentRepository;
    private AppointmentMapper appointmentMapper;

    public ConsultationServiceImpl(ConsultationRepository consultationRepository, ConsultationMapper consultationMapper, EntrepriseMapper entrepriseMapper, EntrepriseRepository entrepriseRepository, AppointmentRepository appointmentRepository, AppointmentMapper appointmentMapper) {
        this.consultationRepository = consultationRepository;
        this.consultationMapper = consultationMapper;
        this.entrepriseRepository = entrepriseRepository;
        this.appointmentRepository = appointmentRepository;
        this.appointmentMapper = appointmentMapper;
    }
    ConsultationDto toDto(Consultation consultation){
        return consultationMapper.toDto(consultation);
    }
    Consultation fromDto(ConsultationDto dto){

        return consultationMapper.fromDto(dto);
    }
    Consultation fromDtoInsert(InsertConsultationDto dto){

        return consultationMapper.fromDtoInsert(dto);
    }
    AppointmentDto getAppointmentDto(Appointment a){
        return appointmentMapper.toDto(a);
    }

    @Override
    public List<ConsultationDto> getAllConsultations() {
        return consultationRepository.findAll()
                .stream()
                .map(
                        this::toDto
                )
                .toList();
    }

    @Override
    public ConsultationDto getConsultationByID(int id) {
        return toDto(consultationRepository.findById( id).get());
    }

    @Override
    public ConsultationDto getConsultationByStartDate(LocalDateTime startDate) {
        return toDto(consultationRepository.findByDateConsultation(startDate));
    }

    @Override
    public ConsultationDto updateConsultation(int id, ConsultationDto dto) {
        if(! consultationRepository.existsById(id)){
            return null;
        }
        return toDto(consultationRepository.save(fromDto(dto)));
    }

    @Override
    public void saveConsultation(InsertConsultationDto dto) {
        if (entrepriseRepository.findById(dto.getEntrepriseId())==null){
            //log("");
        }else{
            ConsultationDto saveDto=new ConsultationDto();
            BeanUtils.copyProperties(dto,saveDto);

            saveDto.setAppointmentDto(getAppointmentDto(appointmentRepository.findById(dto.getAppointmentID()).get()));
             consultationRepository.save(fromDtoInsert(dto));
        }

    }
}
