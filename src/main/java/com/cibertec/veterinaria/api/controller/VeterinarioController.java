package com.cibertec.veterinaria.api.controller;

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
    public ResponseEntity<VeterinarioResponseDto> crear(@RequestBody VeterinarioRequestDto dto) {

        VeterinarioResponseDto nuevo = veterinarioService.crear(dto);
        // 🔹 Envía datos al service

        return ResponseEntity.ok(nuevo);
        // 🔹 Devuelve el veterinario creado
    }
}