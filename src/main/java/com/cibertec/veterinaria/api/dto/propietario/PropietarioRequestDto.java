package com.cibertec.veterinaria.api.dto.propietario;

import jakarta.validation.constraints.NotBlank;

public record PropietarioRequestDto(

        @NotBlank(message = "El código es obligatorio")
        String codigo,

        @NotBlank(message = "El nombre es obligatorio")
        String nombre,

        String telefono,

        @NotBlank(message = "El gmail es obligatorio")
        String gmail

) {}
