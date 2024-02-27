package com.ins.clinique.entities.dtos;

import com.ins.clinique.entities.Appointment;
import com.ins.clinique.entities.CommonEntity;
import com.ins.clinique.enumeration.State;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntrepriseDto {
    private Integer id;
    private String name;
    private String logo;
    private String address;


}
