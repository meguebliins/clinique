package com.ins.clinique.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
//    private String firstName;
//    private String lastName;
//    private String phone;
//    @Column(unique = true)
//    private String mail;
//    private String address;
//    @Column(unique = true,nullable = false)
//    private String login;
//    @Column(nullable = false)
//    private String password;
//
    private int entrepriseID;

}
