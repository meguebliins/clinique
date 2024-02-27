package com.ins.clinique.repositories;

import com.ins.clinique.entities.Admin;
import com.ins.clinique.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {
    Admin findByCode(String code);
}
