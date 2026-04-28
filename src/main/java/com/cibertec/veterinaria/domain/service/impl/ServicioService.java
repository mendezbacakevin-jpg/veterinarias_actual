package com.cibertec.veterinaria.domain.service.impl;


import com.cibertec.veterinaria.api.dto.servicio.ServicioRequestDto;
import com.cibertec.veterinaria.api.dto.servicio.ServicioResponseDto;
import com.cibertec.veterinaria.data.entity.Servicio;
import com.cibertec.veterinaria.data.repository.IServicioRepository;
import com.cibertec.veterinaria.domain.mapper.ServicioMapper;
import com.cibertec.veterinaria.domain.service.interfaces.IServicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicioService implements IServicioService {

    private final IServicioRepository repository;
    private final ServicioMapper mapper;

    @Override
    public List<ServicioResponseDto> listar() {

        List<Servicio> lista = repository.findAll();
        // 🔹 Obtiene todos los servicios de la BD

        return mapper.toResponseList(lista);
        // 🔹 Convierte a DTO
    }

    @Override
    public ServicioResponseDto crear(ServicioRequestDto dto) {

        Servicio entity = mapper.toEntity(dto);
        // 🔹 Convierte JSON → Entity

        Servicio guardado = repository.save(entity);
        // 🔹 Guarda en BD

        return mapper.toResponseDto(guardado);
        // 🔹 Devuelve respuesta
    }
}