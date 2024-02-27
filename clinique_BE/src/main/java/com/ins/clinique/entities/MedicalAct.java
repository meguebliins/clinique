package com.ins.clinique.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "medicalact")
public class MedicalAct extends CommonEntity {
    @Column(nullable = false,unique = true)
    private String act;
    private Double price;
    private String description;
    private String required;
    private int entrepriseId;
}
