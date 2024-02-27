package com.ins.clinique.controllers.apis;

import com.ins.clinique.entities.dtos.AppointmentDto;
import com.ins.clinique.entities.dtos.InsertAppointmentDto;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
@CrossOrigin(origins  = "http://localhost:4200/")
@RequestMapping("appointment")
public interface AppointmentApi {
    @GetMapping("/all")
    List<AppointmentDto> getAllAppointments();
    @GetMapping("/{id}")
    AppointmentDto getAppointmentByID(@PathVariable int id);
    @PutMapping("/{id}")
    AppointmentDto updateAppointment(@PathVariable int id, @RequestBody AppointmentDto dto);
    @PostMapping
    void saveAppointment(@RequestBody InsertAppointmentDto dto);
}
