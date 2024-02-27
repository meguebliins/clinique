package com.ins.clinique.entities;

import com.ins.clinique.enumeration.State;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "appointment")
public class Appointment extends CommonEntity {


    private String img;
    private String name;
    private String email;
    private String gender;
    private Date date;
    private String time;
    private String mobile;
    private String injury;
    @ManyToOne
    @JoinColumn(name = "doctorId")
    private Doctor doctor;
//    @ManyToOne
//    @JoinColumn(name = "patientId")
//    private Patient patient;
//    @ManyToOne
//    @JoinColumn(name = "technicienId")
//    private Technicien technicien;
//    @ManyToOne
//    @JoinColumn(name = "medicalActId")
//    private MedicalAct medicalAct;
//    @Enumerated(EnumType.ORDINAL)

    private int entrepriseId;

}
