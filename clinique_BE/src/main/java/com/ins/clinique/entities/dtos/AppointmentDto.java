package com.ins.clinique.entities.dtos;

import com.ins.clinique.entities.Doctor;
import com.ins.clinique.entities.MedicalAct;
import com.ins.clinique.entities.Patient;
import com.ins.clinique.entities.Technicien;
import com.ins.clinique.enumeration.State;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AppointmentDto {
    private int id;
    private String img;
    private String name;
    private String email;
    private String gender;
    private Date date;
    private String time;
    private String mobile;

    private String injury;
    public DoctorDto doctorDto;
//    private PatientDto patientDto;
//    private TechnicienDto technicienDto;
//    private MedicalActDto medicalActDto;

    private int entrepriseId;
}
