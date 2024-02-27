package com.ins.clinique.entities.dtos;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DoctorDto {
    private Integer id;
    private String img;
    private String specialization;
    private String email;
    private Date date;
    private String department;
    private String mobile;
    private String name;
    private String degree;

    private int entrepriseID;

}
