package com.ins.clinique.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TechnicienDto {
    private Integer id;

    private String img;
    private String designation;
    private String email;
    private Date date;
    private String mobile;
    private String name;
    private String address;

    private int entrepriseID;

}
