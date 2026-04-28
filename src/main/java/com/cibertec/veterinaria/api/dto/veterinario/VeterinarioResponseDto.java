package com.cibertec.veterinaria.api.dto.veterinario;

// 🔹 DTO de salida (lo que devuelve el backend)
public record VeterinarioResponseDto(

        Long id,
        String nombre,
        String especialidad

) {}