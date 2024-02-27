package com.ins.clinique.entities.dtos;

import com.ins.clinique.enumeration.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsertAppointmentDto {
    private int id;
    private String img;
    private String name;
    private String email;
    private String gender;
    private Date date;
    private String time;
    private String mobile;

    private String injury;
    private int doctorDto;
    private int entrepriseId;
}
