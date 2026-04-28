package com.cibertec.veterinaria.domain.service.interfaces;

import com.cibertec.veterinaria.api.dto.cita.CitaRequestDto;
import com.cibertec.veterinaria.api.dto.cita.CitaResponseDto;
import com.cibertec.veterinaria.data.entity.Cita;

import java.util.List;

public interface ICitaService {


    Cita guardarCita(Cita cita);
    List<CitaResponseDto> listarCitas();
    // 🔥 ESTE FALTABA
    CitaResponseDto crear(CitaRequestDto dto);

    List<CitaResponseDto> crearLote(List<CitaRequestDto> lista);

}