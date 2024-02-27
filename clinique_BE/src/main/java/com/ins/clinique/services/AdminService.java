package com.ins.clinique.services;

import com.ins.clinique.entities.dtos.AdminDto;

import java.util.List;

public interface AdminService {
    List<AdminDto> getAllAdmins();
    AdminDto getAdminByID(int id);
    AdminDto getAdminByCode(String code);
    AdminDto updateAdmin(int id, AdminDto dto);
    AdminDto saveAdmin(AdminDto dto);
}
