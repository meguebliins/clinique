package com.ins.clinique.repositories;

import com.ins.clinique.entities.Consultation;
import com.ins.clinique.entities.dtos.EntrepriseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation,Integer> {
    Consultation findByDateConsultation(LocalDateTime dateConsultation);
}
