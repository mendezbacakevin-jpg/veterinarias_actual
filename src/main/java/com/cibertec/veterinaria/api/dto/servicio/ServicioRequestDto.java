package com.cibertec.veterinaria.api.dto.servicio;

// 🔹 Lo que envía el cliente
public record ServicioRequestDto(

        String nombre,
        String descripcion,
        Double precio

) {}