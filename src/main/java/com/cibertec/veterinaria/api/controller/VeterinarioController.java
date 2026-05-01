package com.cibertec.veterinaria.api.controller;
// 🔴 IMPORT CORRECTO
import jakarta.validation.Valid;
import com.cibertec.veterinaria.api.dto.veterinario.VeterinarioRequestDto;
import com.cibertec.veterinaria.api.dto.veterinario.VeterinarioResponseDto;
import com.cibertec.veterinaria.domain.service.interfaces.IVeterinarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veterinarios") // 🔹 Ruta base
@CrossOrigin(origins = "*") // 🔹 Permite conexión externa (Angular / Bruno)
@RequiredArgsConstructor
public class VeterinarioController {

    private final IVeterinarioService veterinarioService;

    // 🔹 LISTAR TODOS
    @GetMapping
    public ResponseEntity<List<VeterinarioResponseDto>> listar() {

        List<VeterinarioResponseDto> lista = veterinarioService.listar();
        // 🔹 Llama al service para obtener datos

        return ResponseEntity.ok(lista);
        // 🔹 Devuelve respuesta en JSON
    }

    // 🔹 CREAR VETERINARIO
    @PostMapping
    public ResponseEntity<VeterinarioResponseDto> crear(@Valid @RequestBody VeterinarioRequestDto dto) {
        //  (AGREGADO) Validación rápida antes de ir al service
        // Evita que lleguen nulls y luego explote en BD o mapper
        if (dto.nombre() == null || dto.nombre().isBlank()) {
            throw new RuntimeException("El nombre es obligatorio");
        }

        if (dto.especialidad() == null || dto.especialidad().isBlank()) {
            throw new RuntimeException("La especialidad es obligatoria");
        }
        VeterinarioResponseDto nuevo = veterinarioService.crear(dto);
        // 🔹 Envía datos al service

        return ResponseEntity.status(201).body(nuevo); // ✅ MEJOR PRÁCTICA (CREACIÓN)
        // 🔹 Devuelve el veterinario creado
    }
}