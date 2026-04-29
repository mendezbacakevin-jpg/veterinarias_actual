package com.cibertec.veterinaria.api.dto.veterinario;
import jakarta.validation.constraints.NotBlank;//cambio
// 🔹 DTO de entrada (lo que envía el cliente)
public record VeterinarioRequestDto(
        @NotBlank(message = "El nombre es obligatorio")
        String nombre,
        @NotBlank(message = "La especialidad es obligatoria")
        String especialidad

) {}