package com.cibertec.veterinaria.api.controller;

import com.cibertec.veterinaria.api.dto.servicio.ServicioRequestDto;
import com.cibertec.veterinaria.api.dto.servicio.ServicioResponseDto;
import com.cibertec.veterinaria.domain.service.interfaces.IServicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicios") // 🔹 endpoint base
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ServicioController {

    private final IServicioService servicioService;

    // 🔹 LISTAR SERVICIOS
    @GetMapping
    public ResponseEntity<List<ServicioResponseDto>> listar() {

        List<ServicioResponseDto> lista = servicioService.listar();
        // 🔹 obtiene todos los servicios

        return ResponseEntity.ok(lista);
        // 🔹 devuelve JSON
    }

    // 🔹 CREAR SERVICIO
    @PostMapping
    public ResponseEntity<ServicioResponseDto> crear(@RequestBody ServicioRequestDto dto) {

        ServicioResponseDto nuevo = servicioService.crear(dto);
        // 🔹 guarda el servicio

        return ResponseEntity.ok(nuevo);
        // 🔹 devuelve el creado
    }
}