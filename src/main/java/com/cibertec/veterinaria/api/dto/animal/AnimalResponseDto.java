package com.cibertec.veterinaria.api.dto.animal;

// 🔴 DTO que devuelve el backend
public record AnimalResponseDto(

        Integer id,
        String nombre,
        String especie,
        String raza,
        double edad,
        String propietarioNombre //  mostramos nombre del dueño

) {}