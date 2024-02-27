package com.ins.clinique.services.impl;

import com.ins.clinique.entities.Admin;
import com.ins.clinique.entities.dtos.AdminDto;
import com.ins.clinique.entities.mappers.AdminMapper;
import com.ins.clinique.entities.mappers.EntrepriseMapper;
import com.ins.clinique.repositories.AdminRepository;
import com.ins.clinique.repositories.EntrepriseRepository;
import com.ins.clinique.services.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    private AdminRepository adminRepository;
    private EntrepriseRepository entrepriseRepository;

    private AdminMapper adminMapper;

    public AdminServiceImpl(AdminRepository adminRepository, AdminMapper adminMapper, EntrepriseMapper entrepriseMapper, EntrepriseRepository entrepriseRepository) {
        this.adminRepository = adminRepository;
        this.adminMapper = adminMapper;
        this.entrepriseRepository = entrepriseRepository;
    }
    AdminDto toDto(Admin admin){
        return adminMapper.toDto(admin);
    }
    Admin fromDto(AdminDto dto){

        return adminMapper.fromDto(dto);
    }

    @Override
    public List<AdminDto> getAllAdmins() {
        return adminRepository.findAll()
                .stream()
                .map(
                        this::toDto
                )
                .toList();
    }

    @Override
    public AdminDto getAdminByID(int id) {
        return toDto(adminRepository.findById( id).get());
    }

    @Override
    public AdminDto getAdminByCode(String code) {
        return toDto(adminRepository.findByCode(code));
    }

    @Override
    public AdminDto updateAdmin(int id, AdminDto dto) {
        if(! adminRepository.existsById(id)){
            return null;
        }
        return toDto(adminRepository.save(fromDto(dto)));
    }

    @Override
    public AdminDto saveAdmin(AdminDto dto) {
        if (entrepriseRepository.findById(dto.getId())==null){
            return null;
        }else{
            return toDto(adminRepository.save(fromDto(dto)));
        }

    }
}
