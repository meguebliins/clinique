package com.ins.clinique.controllers;

import com.ins.clinique.controllers.apis.AdminApi;
import com.ins.clinique.entities.dtos.AdminDto;
import com.ins.clinique.services.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class AdminController implements AdminApi {
    private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @Override
    public List<AdminDto> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @Override
    public AdminDto getAdminByID(int id) {
        return adminService.getAdminByID(id);
    }

    @Override
    public AdminDto getAdminByCode(String code) {
        return adminService.getAdminByCode(code);
    }

    @Override
    public AdminDto updateAdmin(int id, AdminDto dto) {
        return adminService.updateAdmin(id, dto);
    }

    @Override
    public AdminDto saveAdmin(AdminDto dto) {
        return adminService.saveAdmin(dto);
    }
}
