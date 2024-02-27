package com.ins.clinique.repositories;

import com.ins.clinique.entities.Technicien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicienRepository extends JpaRepository<Technicien,Integer> {

}
