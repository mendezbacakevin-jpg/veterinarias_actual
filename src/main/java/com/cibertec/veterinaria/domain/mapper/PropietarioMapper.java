package com.cibertec.veterinaria.domain.mapper;

import com.cibertec.veterinaria.api.dto.propietario.PropietarioRequestDto;
import com.cibertec.veterinaria.api.dto.propietario.PropietarioResponseDto;
import com.cibertec.veterinaria.data.entity.Propietario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PropietarioMapper {

    Propietario toEntity(PropietarioRequestDto dto);

    @Mapping(source = "id_propietario", target = "id")
    PropietarioResponseDto toResponseDto(Propietario entity);

    List<PropietarioResponseDto> toList(List<Propietario> lista);
}