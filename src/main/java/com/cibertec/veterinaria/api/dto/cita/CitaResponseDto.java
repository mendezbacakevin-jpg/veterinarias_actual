package com.cibertec.veterinaria.api.dto.cita;

import java.time.LocalDate;
import java.time.LocalTime;

public record CitaResponseDto(
        Integer idCita,
        String nombreMascota,
        LocalDate fecha,
        LocalTime hora,
        String estado,
        String motivo,
        String nombreVeterinario,
        String nombreServicio,
        Integer id_animal,
        Integer id_servicio,
        Integer id_veterinario
) {
}