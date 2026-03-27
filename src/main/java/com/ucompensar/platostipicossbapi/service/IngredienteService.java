package com.ucompensar.platostipicossbapi.service;

import com.ucompensar.platostipicossbapi.dto.IngredienteDto;
import com.ucompensar.platostipicossbapi.dto.IngredienteSaveDto;
import com.ucompensar.platostipicossbapi.entity.Ingrediente;
import com.ucompensar.platostipicossbapi.repository.IngredienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredienteService {

    private final IngredienteRepository ingredienteRepository;

    public IngredienteService(IngredienteRepository ingredienteRepository) {
        this.ingredienteRepository = ingredienteRepository;
    }

    public List<IngredienteDto> findAll() {
        return ingredienteRepository.findAll().stream().map(IngredienteDto::toDto).toList();
    }

    public IngredienteDto findById(Long id) {
        return ingredienteRepository.findById(id)
                .map(IngredienteDto::toDto)
                .orElseThrow(() -> new RuntimeException("Ingrediente con ID " + id + " no encontrado"));
    }

    public IngredienteDto save(IngredienteSaveDto ingredienteDto) {
        Ingrediente ingrediente = ingredienteDto.toEntity();
        return IngredienteDto.toDto(ingredienteRepository.save(ingrediente));
    }

    public IngredienteDto update(Long id, IngredienteSaveDto ingredienteDto) {
        Ingrediente ingrediente = ingredienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ingrediente con ID " + id + " no encontrado"));

        ingrediente.setNombre(ingredienteDto.getNombre());
        return IngredienteDto.toDto(ingredienteRepository.save(ingrediente));
    }

    public void delete(Long id) {
        if (!ingredienteRepository.existsById(id)) {
            throw new RuntimeException("Ingrediente con ID " + id + " no encontrado");
        }
        ingredienteRepository.deleteById(id);
    }
}
