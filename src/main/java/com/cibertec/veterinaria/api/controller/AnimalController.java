package com.cibertec.veterinaria.api.controller;

import com.cibertec.veterinaria.api.dto.animal.AnimalRequestDto;
import com.cibertec.veterinaria.domain.service.interfaces.IAnimalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/animales")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AnimalController {

    private final IAnimalService animalService;

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody AnimalRequestDto dto) {
        return ResponseEntity.ok(animalService.crear(dto));
    }

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(animalService.listar());
    }
}