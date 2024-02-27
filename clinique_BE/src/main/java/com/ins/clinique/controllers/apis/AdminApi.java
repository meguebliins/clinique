package com.ins.clinique.controllers.apis;

import com.ins.clinique.entities.dtos.AdminDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("admin")
public interface AdminApi {
    @GetMapping("/all")
    List<AdminDto> getAllAdmins();
    @GetMapping("/{id}")
    AdminDto getAdminByID(@PathVariable int id);
    @GetMapping
    AdminDto getAdminByCode(@RequestParam String code);
    @PutMapping("/{id}")
    AdminDto updateAdmin(@PathVariable int id, @RequestBody AdminDto dto);
    @PostMapping
    AdminDto saveAdmin(@RequestBody AdminDto dto);
}
