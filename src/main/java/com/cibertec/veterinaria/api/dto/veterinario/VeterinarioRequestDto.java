package com.cibertec.veterinaria.api.dto.veterinario;
// 🔹 DTO de entrada (lo que envía el cliente)
public record VeterinarioRequestDto(

        String nombre,
        String especialidad

) {}