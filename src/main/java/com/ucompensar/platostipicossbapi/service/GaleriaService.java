package com.ucompensar.platostipicossbapi.service;

import com.ucompensar.platostipicossbapi.dto.GaleriaDto;
import com.ucompensar.platostipicossbapi.dto.GaleriaSaveDto;
import com.ucompensar.platostipicossbapi.entity.Galeria;
import com.ucompensar.platostipicossbapi.entity.Plato;
import com.ucompensar.platostipicossbapi.repository.GaleriaRepository;
import com.ucompensar.platostipicossbapi.repository.PlatoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GaleriaService {

    private final GaleriaRepository galeriaRepository;
    private final PlatoRepository platoRepository;

    public GaleriaService(GaleriaRepository galeriaRepository, PlatoRepository platoRepository) {
        this.galeriaRepository = galeriaRepository;
        this.platoRepository = platoRepository;
    }

    public List<GaleriaDto> findAll() {
        return galeriaRepository.findAll().stream().map(GaleriaDto::toDto).toList();
    }

    public GaleriaDto save(Long platoId, GaleriaSaveDto dto) {
        Plato plato = platoRepository.findById(platoId)
                .orElseThrow(() -> new RuntimeException("Plato no encontrado"));

        Galeria galeria = dto.toEntity();
        galeria.setPlato(plato);
        
        return GaleriaDto.toDto(galeriaRepository.save(galeria));
    }

    public void delete(Long id) {
        if (!galeriaRepository.existsById(id)) {
            throw new RuntimeException("Imagen no encontrada");
        }
        galeriaRepository.deleteById(id);
    }
}
