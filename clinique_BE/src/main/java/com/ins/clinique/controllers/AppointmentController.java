package com.ins.clinique.controllers;

import com.ins.clinique.controllers.apis.AppointmentApi;
import com.ins.clinique.entities.dtos.AppointmentDto;
import com.ins.clinique.entities.dtos.InsertAppointmentDto;
import com.ins.clinique.services.AppointmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@Slf4j
public class AppointmentController implements AppointmentApi {
    private AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @Override
    public List<AppointmentDto> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @Override
    public AppointmentDto getAppointmentByID(int id) {
        return appointmentService.getAppointmentByID(id);
    }

    @Override
    public AppointmentDto updateAppointment(int id, AppointmentDto dto) {
        return appointmentService.updateAppointment(id, dto);
    }

    @Override
    public void saveAppointment(InsertAppointmentDto dto) {
         appointmentService.saveAppointment(dto);
    }
}
