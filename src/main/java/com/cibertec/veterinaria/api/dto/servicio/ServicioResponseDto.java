package com.cibertec.veterinaria.api.dto.servicio;
// 🔹 Lo que devuelve el backend
public record ServicioResponseDto(
        Integer id,
        String nombre,
        String descripcion,
        Double precio

)
{ }
