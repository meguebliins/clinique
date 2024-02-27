package com.ins.clinique.repositories;

import com.ins.clinique.entities.MedicalAct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalActRepository extends JpaRepository<MedicalAct,Integer> {
}
