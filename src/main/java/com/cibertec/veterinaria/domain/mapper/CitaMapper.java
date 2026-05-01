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

    @Mapping(target = "animal", ignore = true)
    @Mapping(target = "veterinario", ignore = true)
    @Mapping(target = "servicio", ignore = true)
    @Mapping(target = "estadoCita", ignore = true)

    Cita toEntity(CitaRequestDto dto);

    @Mapping(source = "motivo", target = "motivo")
    @Mapping(source = "id_cita", target = "idCita")
    @Mapping(source = "animal.id_animal", target = "id_animal")
    @Mapping(source = "servicio.id_servicio", target = "id_servicio")
    @Mapping(source = "veterinario.id_veterinario", target = "id_veterinario")
    @Mapping(source = "animal.nombre", target = "nombreMascota")
    @Mapping(source = "veterinario.nombre", target = "nombreVeterinario")
    @Mapping(source = "servicio.nombre_servicio", target = "nombreServicio")
    //  SOLUCIÓN: acceder al nombre del estado
    @Mapping(source = "estadoCita.nombre_estado", target = "estado")

    CitaResponseDto toResponseDto(Cita cita);

    List<CitaResponseDto> toResponseDtoList(List<Cita> citas);

    default String map(EstadoCita estadoCita) {
        if (estadoCita == null) return null;
        return estadoCita.getNombre_estado();
    }
}