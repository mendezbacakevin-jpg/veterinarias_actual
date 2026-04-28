package com.cibertec.veterinaria.domain.service.interfaces;

import com.cibertec.veterinaria.api.dto.servicio.ServicioRequestDto;
import com.cibertec.veterinaria.api.dto.servicio.ServicioResponseDto;

import java.util.List;


public interface IServicioService {

    List<ServicioResponseDto> listar();

    ServicioResponseDto crear(ServicioRequestDto dto);
}