package com.cibertec.veterinaria.api.dto.propietario;

public record PropietarioResponseDto(

        Integer id,
        String codigo,
        String nombre,
        String telefono,
        String gmail

) {}