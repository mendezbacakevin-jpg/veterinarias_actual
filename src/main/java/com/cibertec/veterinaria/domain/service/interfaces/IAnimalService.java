package com.cibertec.veterinaria.domain.service.interfaces;

import com.cibertec.veterinaria.api.dto.animal.AnimalRequestDto;
import com.cibertec.veterinaria.api.dto.animal.AnimalResponseDto;

import java.util.List;

public interface IAnimalService {

    AnimalResponseDto crear(AnimalRequestDto dto);

    List<AnimalResponseDto> listar();
}