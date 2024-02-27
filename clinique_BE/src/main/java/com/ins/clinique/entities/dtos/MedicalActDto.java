package com.ins.clinique.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalActDto {
    private Integer id;
    private String act;
    private Double price;
    private String description;
    private String required;
    private int entrepriseId;
}
