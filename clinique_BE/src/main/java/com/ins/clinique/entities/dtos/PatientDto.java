package com.ins.clinique.entities.dtos;

import com.ins.clinique.entities.Entreprise;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
    @AllArgsConstructor
    @NoArgsConstructor
public class PatientDto {
    private Integer id;
    private String img;
    private String gender;
    private String bGroup;
    private Date date;
    private String mobile;
    private String name;
    private String address;
    private String treatment;
    private int entrepriseID;

    }
