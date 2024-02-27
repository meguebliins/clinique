package com.ins.clinique.entities.dtos;

import com.ins.clinique.enumeration.State;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsertConsultationDto {
    private int id;
    private LocalDate dateConsultation;
    private int periodConsultation; //en minute
    private String description;
    private double cost;
    private State state;
    private int entrepriseId;
    private int appointmentID;

}
