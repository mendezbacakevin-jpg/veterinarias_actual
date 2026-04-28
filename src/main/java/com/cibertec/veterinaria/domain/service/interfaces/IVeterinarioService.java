package com.cibertec.veterinaria.domain.service.interfaces;
import com.cibertec.veterinaria.api.dto.veterinario.VeterinarioRequestDto;
import com.cibertec.veterinaria.api.dto.veterinario.VeterinarioResponseDto;

import java.util.List;

public interface IVeterinarioService {

    List<VeterinarioResponseDto> listar();

    VeterinarioResponseDto crear(VeterinarioRequestDto dto);

}