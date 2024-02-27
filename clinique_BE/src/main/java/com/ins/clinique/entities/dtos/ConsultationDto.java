package com.ins.clinique.entities.dtos;

import com.ins.clinique.entities.Appointment;
import com.ins.clinique.enumeration.State;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultationDto {
    private int id;
    private LocalDate dateConsultation;
    private int periodConsultation; //en minute
    private String description;
    private double cost;

    private State state;
    private int entrepriseId;

    public AppointmentDto appointmentDto;
    private String numFact;
    private double tva;
}
