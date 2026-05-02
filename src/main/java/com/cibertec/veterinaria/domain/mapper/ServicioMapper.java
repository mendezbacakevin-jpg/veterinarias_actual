package com.cibertec.veterinaria.domain.mapper;
import com.cibertec.veterinaria.api.dto.servicio.ServicioRequestDto;
import com.cibertec.veterinaria.api.dto.servicio.ServicioResponseDto;
import com.cibertec.veterinaria.data.entity.Servicio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ServicioMapper {

    // 🔹 DTO → ENTITY
    @Mapping(source = "nombre", target = "nombre_servicio")
    Servicio toEntity(ServicioRequestDto dto);

    // 🔹 ENTITY → DTO
    @Mapping(source = "id_servicio", target = "id")
    @Mapping(source = "nombre_servicio", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    @Mapping(source = "icono", target = "icono")
    ServicioResponseDto toResponseDto(Servicio entity);

    // 🔹 DTO → ENTITY
    //Servicio toEntity(ServicioRequestDto dto);


    // 🔹 ENTITY → DTO
    //ServicioResponseDto toResponseDto(Servicio entity);

    // 🔹 LISTA
    List<ServicioResponseDto> toResponseList(List<Servicio> lista);
}
