package com.ins.clinique.repositories;

import com.ins.clinique.entities.Doctor;
import com.ins.clinique.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
   // Doctor findByCode(String code);
}
