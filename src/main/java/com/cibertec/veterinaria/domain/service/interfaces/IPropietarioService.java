package com.cibertec.veterinaria.domain.service.interfaces;

import com.cibertec.veterinaria.api.dto.propietario.PropietarioRequestDto;
import com.cibertec.veterinaria.api.dto.propietario.PropietarioResponseDto;

import java.util.List;

public interface IPropietarioService {

    PropietarioResponseDto crear(PropietarioRequestDto dto);

    List<PropietarioResponseDto> listar();
}