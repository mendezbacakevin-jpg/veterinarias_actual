package com.cibertec.veterinaria.domain.mapper;
import com.cibertec.veterinaria.api.dto.veterinario.VeterinarioRequestDto;
import com.cibertec.veterinaria.api.dto.veterinario.VeterinarioResponseDto;
import com.cibertec.veterinaria.data.entity.Veterinario;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VeterinarioMapper {

    // 🔹 DTO → ENTITY
    Veterinario toEntity(VeterinarioRequestDto dto);

    // 🔹 ENTITY → DTO
    VeterinarioResponseDto toResponseDto(Veterinario entity);

    // 🔹 LISTA
    List<VeterinarioResponseDto> toResponseList(List<Veterinario> lista);
}