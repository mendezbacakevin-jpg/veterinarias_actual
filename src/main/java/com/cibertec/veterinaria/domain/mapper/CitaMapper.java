package com.cibertec.veterinaria.domain.mapper;

import com.cibertec.veterinaria.api.dto.cita.CitaRequestDto;
import com.cibertec.veterinaria.api.dto.cita.CitaResponseDto;
import com.cibertec.veterinaria.data.entity.Cita;
import com.cibertec.veterinaria.data.entity.EstadoCita;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CitaMapper {

    // 🔹 DTO → ENTITY
    // ❌ TENÍAS DUPLICADO ESTE MÉTODO → ERROR
    Cita toEntity(CitaRequestDto dto);

    // 🔹 ENTITY → DTO
    @Mapping(source = "id_cita", target = "idCita")
    // 🔹 Mapear id de BD → DTO (porque nombres distintos)

    @Mapping(source = "estadoCita", target = "estado")
    // 🔹 Tu entity tiene "estadoCita" pero el DTO "estado"

    @Mapping(source = "animal.nombre", target = "nombreMascota")
    // 🔹 IMPORTANTE: si no mapeas relaciones → sale null

    CitaResponseDto toResponseDto(Cita cita);

    // 🔹 LISTA
    List<CitaResponseDto> toResponseDtoList(List<Cita> citas);
    default String map(EstadoCita estadoCita) {
        // 🔹 Si es null, evita error
        if (estadoCita == null) {
            return null;
        }
        // 🔹 Devuelve el nombre o descripción
        return estadoCita.getNombre_estado(); // 👈 ajusta según tu entidad
    }
}