package com.cibertec.veterinaria.domain.service.impl;

import com.cibertec.veterinaria.api.dto.cita.CitaRequestDto;
import com.cibertec.veterinaria.api.dto.cita.CitaResponseDto;
import com.cibertec.veterinaria.data.entity.Cita;
import com.cibertec.veterinaria.data.repository.ICitaRepository;
import com.cibertec.veterinaria.domain.mapper.CitaMapper;
import com.cibertec.veterinaria.domain.service.interfaces.ICitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CitaService implements ICitaService {

    private final ICitaRepository citaRepository;
    private final CitaMapper citaMapper;

    @Override
    public Cita guardarCita(Cita cita) {
        Cita respuesta = citaRepository.save(cita);

        return respuesta;
    }

    @Override
    public List<CitaResponseDto> listarCitas() {
        return citaMapper.toResponseDtoList(citaRepository.findAll());
    }
    @Override
    public CitaResponseDto crear(CitaRequestDto dto) {
        Cita cita = citaMapper.toEntity(dto);
        Cita guardada = citaRepository.save(cita);
        return citaMapper.toResponseDto(guardada);
    }
    @Override
    public List<CitaResponseDto> crearLote(List<CitaRequestDto> lista) {
        return lista.stream()
                .map(dto -> crear(dto)) // reutilizas tu método crear
                .toList();
    }
}
