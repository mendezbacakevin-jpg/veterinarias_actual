package com.cibertec.veterinaria.api.controller;

import com.cibertec.veterinaria.api.dto.cita.CitaRequestDto;

import com.cibertec.veterinaria.domain.service.interfaces.ICitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity; // ✅ IMPORT FALTANTE
import org.springframework.web.bind.annotation.*;
// 🔴 AGREGADO: import correcto para @Valid
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/citas")
@CrossOrigin(origins = "*")
public class CitaController {

    @Autowired
    private ICitaService citaService;

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(citaService.listarCitas());
    }

    // 🔴 AGREGADO: ESTE ES EL REGISTRO REAL
    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody CitaRequestDto dto) {
        return ResponseEntity.ok(citaService.crear(dto));
    }

    @PostMapping("/lote")
    public ResponseEntity<?> crearLote(@RequestBody List<CitaRequestDto> lista) {
        return ResponseEntity.ok(citaService.crearLote(lista));
    }
    // 👇 AGREGADO: obtener cita por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> obtener(@PathVariable Integer id) {
        return ResponseEntity.ok(citaService.obtenerPorId(id));
    }

    // 👇 AGREGADO: actualizar cita
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Integer id,
                                        @Valid @RequestBody CitaRequestDto dto) {
        return ResponseEntity.ok(citaService.actualizar(id, dto));
    }

    // 👇 AGREGADO: eliminar cita
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        citaService.eliminar(id); // 👈 sigue eliminando la cita en BD
        return ResponseEntity.ok("Cita " + id + " eliminada"); // 👈 ahora devuelve mensaje
    }


}