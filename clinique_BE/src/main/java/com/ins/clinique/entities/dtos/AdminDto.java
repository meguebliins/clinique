package com.ins.clinique.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDto {
private Integer id;
private String firstName;
private String lastName;
private String phone;

private String mail;
private String address;

private String login;

private String password;

private String code;

private String speciality;

    private int entrepriseID;
}
