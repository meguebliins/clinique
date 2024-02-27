package com.ins.clinique.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "doctor")
public class Doctor extends Staff{
    private String img;
    private String specialization;
    private String email;
    private Date date;
    private String department;
    private String mobile;
    private String name;
    private String degree;
}
