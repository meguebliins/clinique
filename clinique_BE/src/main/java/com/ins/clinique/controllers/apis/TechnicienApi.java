package com.ins.clinique.controllers.apis;

import com.ins.clinique.entities.dtos.TechnicienDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins  = "http://localhost:4200/")
@RequestMapping("technicien")
public interface TechnicienApi {
    @GetMapping("/all")
    List<TechnicienDto> getAllTechniciens();
    @GetMapping("/{id}")
    TechnicienDto getTechnicienByID(@PathVariable int id);
    @PutMapping("/{id}")
    TechnicienDto updateTechnicien(@PathVariable int id, @RequestBody TechnicienDto dto);
    @PostMapping
    TechnicienDto saveTechnicien(@RequestBody TechnicienDto dto);
}
