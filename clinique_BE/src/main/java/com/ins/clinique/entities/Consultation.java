package com.ins.clinique.entities;

import com.ins.clinique.enumeration.State;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "consultation")
public  class Consultation extends CommonEntity {
    private LocalDate dateConsultation;
    private int periodConsultation; //en minute
    private String description;
    private double cost;

    @Enumerated(EnumType.ORDINAL)
    private State state;
    private int entrepriseId;
    @OneToOne
    @JoinColumn(name = "appointmentId")
    private Appointment appointment;
    private String numFact;
    private double tva;
}
