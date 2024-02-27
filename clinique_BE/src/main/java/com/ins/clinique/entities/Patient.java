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
@Table(name = "patient")
public class Patient extends Staff{
    

        private String img;
        private String gender;
        private String bGroup;
        private Date date;
        private String mobile;
        private String name;
        private String address;
        private String treatment;
    
}
