package com.cibertec.veterinaria.domain.service.impl;

import com.cibertec.veterinaria.api.dto.cita.CitaRequestDto;
import com.cibertec.veterinaria.api.dto.cita.CitaResponseDto;
import com.cibertec.veterinaria.data.entity.Cita;
import com.cibertec.veterinaria.data.repository.*;

// AGREGADO: imports de repositorios que estás usando

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

    //  AGREGADO: repositorios para manejar relaciones (CLAVE)
    private final IAnimalRepository animalRepository;
    private final IVeterinarioRepository veterinarioRepository;
    private final IServicioRepository servicioRepository;
    private final IEstadoCitaRepository estadoCitaRepository; //  AGREGADO

    @Override
    public CitaResponseDto crear(CitaRequestDto dto) {

        //  VALIDACIÓN BÁSICA (evita nulls)
        if (dto.fecha() == null || dto.hora() == null) {
            throw new RuntimeException("Fecha y hora son obligatorias");
        }

        //  VALIDACIÓN EXTRA (recomendado)
        if (dto.idAnimal() == null || dto.idServicio() == null) {
            throw new RuntimeException("Animal y servicio son obligatorios");
        }

        Cita cita = citaMapper.toEntity(dto);
        // 🔹 Convierte DTO → Entity (sin relaciones aún)

        //  AGREGADO: asignar ANIMAL desde BD
        cita.setAnimal(
                animalRepository.findById(dto.idAnimal())
                        .orElseThrow(() -> new RuntimeException("Animal no encontrado"))
        );

        //  AGREGADO: asignar SERVICIO
        cita.setServicio(
                servicioRepository.findById(dto.idServicio())
                        .orElseThrow(() -> new RuntimeException("Servicio no encontrado"))
        );
        //  AGREGADO: asignar estado por defecto
        cita.setEstadoCita(
                estadoCitaRepository.findById(1)
                        .orElseThrow(() -> new RuntimeException("Estado no encontrado"))
        );

        //  AGREGADO: veterinario opcional
        if (dto.idVeterinario() != null) {
            cita.setVeterinario(
                    veterinarioRepository.findById(dto.idVeterinario())
                            .orElseThrow(() -> new RuntimeException("Veterinario no encontrado"))
            );
        }

        //  AGREGADO: fecha registro automática
        cita.setFecha_registro(new java.sql.Date(System.currentTimeMillis()));

        //  OPCIONAL PERO RECOMENDADO
        if (cita.getTotal() == null) {
            cita.setTotal(cita.getPrecio_cita());
        }

        Cita guardada = citaRepository.save(cita);

        return citaMapper.toResponseDto(guardada);
    }

    //  AGREGADO: IMPLEMENTACIÓN FALTANTE
    @Override
    public Cita guardarCita(Cita cita) {
        return citaRepository.save(cita);
    }

    //  AGREGADO: IMPLEMENTACIÓN FALTANTE
    @Override
    public List<CitaResponseDto> listarCitas() {
        return citaMapper.toResponseDtoList(citaRepository.findAll());
    }

    // AGREGADO: IMPLEMENTACIÓN FALTANTE
    @Override
    public List<CitaResponseDto> crearLote(List<CitaRequestDto> lista) {
        return lista.stream()
                .map(this::crear) // reutiliza tu método crear
                .toList();
    }
    // 👇 AGREGADO: obtener por ID
    @Override
    public CitaResponseDto obtenerPorId(Integer id) {
        Cita cita = citaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));
        return citaMapper.toResponseDto(cita);
    }

    //  AGREGADO: actualizar
    @Override
    public CitaResponseDto actualizar(Integer id, CitaRequestDto dto) {
        Cita cita = citaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));

        // reutiliza tu lógica de asignación
        cita.setAnimal(animalRepository.findById(dto.idAnimal())
                .orElseThrow(() -> new RuntimeException("Animal no encontrado")));
        cita.setServicio(servicioRepository.findById(dto.idServicio())
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado")));
        if (dto.idVeterinario() != null) {
            cita.setVeterinario(veterinarioRepository.findById(dto.idVeterinario())
                    .orElseThrow(() -> new RuntimeException("Veterinario no encontrado")));
        }
        cita.setFecha(java.sql.Date.valueOf(dto.fecha())); // 👈 convierte
        cita.setHora(dto.hora());
        cita.setMotivo(dto.motivo());

        Cita actualizada = citaRepository.save(cita);
        return citaMapper.toResponseDto(actualizada);
    }

    //  AGREGADO: eliminar
    @Override
    public void eliminar(Integer id) {
        if (!citaRepository.existsById(id)) {
            throw new RuntimeException("Cita no encontrada");
        }
        citaRepository.deleteById(id);
    }
}