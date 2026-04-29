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

        // cambioo(AGREGADO) Protección extra por si bypassan validación del controller
        if (dto == null) {
            throw new RuntimeException("El request no puede ser nulo");
        }

        Veterinario entity = mapper.toEntity(dto);
        // 🔹 Convierte JSON → Entity

        // 🔴 (MEJORA IMPORTANTE) Evita guardar nulls accidentales en entidad
        if (entity.getNombre() == null || entity.getNombre().isBlank()) {
            throw new RuntimeException("Nombre inválido");
        }

        if (entity.getEspecialidad() == null || entity.getEspecialidad().isBlank()) {
            throw new RuntimeException("Especialidad inválida");
        }

        Veterinario guardado = repository.save(entity);
        // 🔹 Guarda en base de datos

        return mapper.toResponseDto(guardado);
    }
}