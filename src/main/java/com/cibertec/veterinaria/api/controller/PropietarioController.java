package com.cibertec.veterinaria.api.controller;

import com.cibertec.veterinaria.api.dto.propietario.PropietarioRequestDto;
import com.cibertec.veterinaria.domain.service.interfaces.IPropietarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //  CAMBIADO (antes era @Controller)
@RequestMapping("/api/propietarios") //  mejor en plural
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class PropietarioController {

    private final IPropietarioService propietarioService; //  CORREGIDO

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody PropietarioRequestDto dto) {
        return ResponseEntity.ok(propietarioService.crear(dto));
    }

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(propietarioService.listar());
    }
}