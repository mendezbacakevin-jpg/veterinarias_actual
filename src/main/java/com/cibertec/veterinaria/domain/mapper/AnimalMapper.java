package com.cibertec.veterinaria.domain.mapper;

import com.cibertec.veterinaria.api.dto.animal.AnimalRequestDto;
import com.cibertec.veterinaria.api.dto.animal.AnimalResponseDto;
import com.cibertec.veterinaria.data.entity.Animal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnimalMapper {

    // 🔴 IMPORTANTE: ignoramos propietario (lo seteamos en service)
    @Mapping(target = "propietario", ignore = true)
    Animal toEntity(AnimalRequestDto dto);

    // 🔴 mapear campos distintos
    @Mapping(source = "id_animal", target = "id")
    @Mapping(source = "propietario.nombre", target = "propietarioNombre")
    AnimalResponseDto toResponseDto(Animal animal);

    List<AnimalResponseDto> toList(List<Animal> lista);
}