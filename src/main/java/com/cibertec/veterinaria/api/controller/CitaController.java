package com.cibertec.veterinaria.api.controller;

import com.cibertec.veterinaria.api.dto.cita.CitaRequestDto;
import com.cibertec.veterinaria.data.entity.Cita;
import com.cibertec.veterinaria.domain.service.interfaces.ICitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity; // ✅ IMPORT FALTANTE
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
@CrossOrigin(origins = "*")
public class CitaController {

    @Autowired
    private ICitaService citaService;

    // 🔹 LISTAR
    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(citaService.listarCitas());
    }

    // 🔹 CREAR (SIN DTO)
    @PostMapping("/lote")
    public ResponseEntity<?> crearLote(@RequestBody List<CitaRequestDto> lista) {
        return ResponseEntity.ok(citaService.crearLote(lista));
    }
}