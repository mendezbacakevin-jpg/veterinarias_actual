package com.cibertec.veterinaria.domain.service.impl;

import com.cibertec.veterinaria.api.dto.propietario.PropietarioRequestDto;
import com.cibertec.veterinaria.api.dto.propietario.PropietarioResponseDto;
import com.cibertec.veterinaria.data.entity.Propietario;
import com.cibertec.veterinaria.data.repository.IPropietarioRepository;
import com.cibertec.veterinaria.domain.mapper.PropietarioMapper;
import com.cibertec.veterinaria.domain.service.interfaces.IPropietarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PropietarioService implements IPropietarioService {

    private final IPropietarioRepository repository;
    private final PropietarioMapper mapper;

    @Override
    public PropietarioResponseDto crear(PropietarioRequestDto dto) {

        //  VALIDACIÓN EXTRA
        if (dto.nombre() == null || dto.nombre().isBlank()) {
            throw new RuntimeException("Nombre obligatorio");
        }

        Propietario entity = mapper.toEntity(dto);

        Propietario guardado = repository.save(entity);

        return mapper.toResponseDto(guardado);
    }

    @Override
    public List<PropietarioResponseDto> listar() {
        return mapper.toList(repository.findAll());
    }
}