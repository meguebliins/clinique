package com.ins.clinique.controllers.apis;

import com.ins.clinique.entities.dtos.EntrepriseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("clinique")
public interface EntrepriseAPI {
    @GetMapping("/all")
    List<EntrepriseDto> getAllEntreprise();
    @GetMapping("/{id}")
    EntrepriseDto getEntrepriseById(@PathVariable int id);
    @PostMapping
    EntrepriseDto saveEntreprise(@RequestBody EntrepriseDto dto);
    @PutMapping("/{id}")
    EntrepriseDto updateEntreprise(@PathVariable int id, @RequestBody EntrepriseDto dto);
}
