package com.ins.clinique.repositories;

import com.ins.clinique.entities.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EntrepriseRepository extends JpaRepository<Entreprise,Integer> {
}
