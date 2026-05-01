package com.cibertec.veterinaria.api.dto.animal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

//  DTO que recibe el JSON
public record AnimalRequestDto(

        @NotBlank(message = "El nombre es obligatorio")
        String nombre,

        String raza,

        @NotBlank(message = "La especie es obligatoria")
        String especie,

        @Positive(message = "La edad debe ser mayor a 0")
        double edad,

        String sexo,
        String color,

        // 🔴 CLAVE: enviamos ID, no objeto
        @NotNull(message = "El propietario es obligatorio")
        Integer idPropietario

) {}