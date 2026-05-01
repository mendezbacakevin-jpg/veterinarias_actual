package com.cibertec.veterinaria.api.dto.cita;
import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.validation.constraints.NotNull;

public record CitaRequestDto(

        // agre  AGREGADO: ahora sí mandas IDs reales (como tu BD)
        @NotNull(message = "El id del animal es obligatorio")
        Integer idAnimal,

        @NotNull(message = "El id del servicio es obligatorio")
        Integer idServicio,

        //  OPCIONAL (puede ser null como tu entity)
        Integer idVeterinario,

        @NotNull(message = "La fecha es obligatoria")
        LocalDate fecha,

        @NotNull(message = "La hora es obligatoria")
        LocalTime hora,

        String motivo

) {}
