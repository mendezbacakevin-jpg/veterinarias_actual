package com.cibertec.veterinaria.domain.service.impl;

import com.cibertec.veterinaria.api.dto.animal.AnimalRequestDto;
import com.cibertec.veterinaria.api.dto.animal.AnimalResponseDto;
import com.cibertec.veterinaria.data.entity.Animal;
import com.cibertec.veterinaria.data.repository.IAnimalRepository;

// 🔴 AGREGADO: necesitas este repo
import com.cibertec.veterinaria.data.repository.IPropietarioRepository;

import com.cibertec.veterinaria.domain.mapper.AnimalMapper;
import com.cibertec.veterinaria.domain.service.interfaces.IAnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalService implements IAnimalService {

    private final IAnimalRepository animalRepository;
    private final AnimalMapper mapper;

    //  CLAVE: para relación
    private final IPropietarioRepository propietarioRepository;

    @Override
    public AnimalResponseDto crear(AnimalRequestDto dto) {

        //  VALIDACIÓN EXTRA
        if (dto.nombre() == null || dto.nombre().isBlank()) {
            throw new RuntimeException("Nombre obligatorio");
        }

        Animal animal = mapper.toEntity(dto);

        // sAGREGADO: asignar propietario desde BD
        animal.setPropietario(
                propietarioRepository.findById(dto.idPropietario())
                        .orElseThrow(() -> new RuntimeException("Propietario no encontrado"))
        );

        Animal guardado = animalRepository.save(animal);

        return mapper.toResponseDto(guardado);
    }

    @Override
    public List<AnimalResponseDto> listar() {
        return mapper.toList(animalRepository.findAll());
    }
}
