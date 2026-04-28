package com.cibertec.veterinaria.domain.service.impl;
import com.cibertec.veterinaria.api.dto.veterinario.VeterinarioRequestDto;
import com.cibertec.veterinaria.api.dto.veterinario.VeterinarioResponseDto;
import com.cibertec.veterinaria.data.entity.Veterinario;
import com.cibertec.veterinaria.data.repository.IVeterinarioRepository;
import com.cibertec.veterinaria.domain.mapper.VeterinarioMapper;
import com.cibertec.veterinaria.domain.service.interfaces.IVeterinarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VeterinarioService implements IVeterinarioService {

    private final IVeterinarioRepository repository;
    private final VeterinarioMapper mapper;

    @Override
    public List<VeterinarioResponseDto> listar() {

        List<Veterinario> lista = repository.findAll();
        // 🔹 Obtiene todos los veterinarios de la BD

        return mapper.toResponseList(lista);
        // 🔹 Convierte Entity → DTO
    }

    @Override
    public VeterinarioResponseDto crear(VeterinarioRequestDto dto) {

        Veterinario entity = mapper.toEntity(dto);
        // 🔹 Convierte JSON → Entity

        Veterinario guardado = repository.save(entity);
        // 🔹 Guarda en base de datos

        return mapper.toResponseDto(guardado);
        // 🔹 Devuelve el resultado como DTO
    }
}