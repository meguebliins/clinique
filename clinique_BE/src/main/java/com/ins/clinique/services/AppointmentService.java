package com.ins.clinique.services;

import com.ins.clinique.entities.dtos.AppointmentDto;
import com.ins.clinique.entities.dtos.InsertAppointmentDto;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentService {
    List<AppointmentDto> getAllAppointments();
    AppointmentDto getAppointmentByID(int id);

    AppointmentDto updateAppointment(int id, AppointmentDto dto);
    void saveAppointment(InsertAppointmentDto dto);
}
