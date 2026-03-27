package com.ucompensar.platostipicossbapi.service;

import com.ucompensar.platostipicossbapi.dto.CategoriaDto;
import com.ucompensar.platostipicossbapi.dto.CategoriaSaveDto;
import com.ucompensar.platostipicossbapi.entity.Categoria;
import com.ucompensar.platostipicossbapi.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<CategoriaDto> findAll() {
        return categoriaRepository.findAll().stream().map(CategoriaDto::toDto).toList();
    }

    public CategoriaDto findById(Long id) {
        return categoriaRepository.findById(id)
                .map(CategoriaDto::toDto)
                .orElseThrow(() -> new RuntimeException("Categoría con ID " + id + " no encontrada"));
    }

    public CategoriaDto save(CategoriaSaveDto categoriaDto) {
        Categoria categoria = categoriaDto.toEntity();
        return CategoriaDto.toDto(categoriaRepository.save(categoria));
    }

    public CategoriaDto update(Long id, CategoriaSaveDto categoriaDto) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría con ID " + id + " no encontrada"));

        categoria.setNombre(categoriaDto.getNombre());
        return CategoriaDto.toDto(categoriaRepository.save(categoria));
    }

    public void delete(Long id) {
        if (!categoriaRepository.existsById(id)) {
            throw new RuntimeException("Categoría con ID " + id + " no encontrada");
        }
        categoriaRepository.deleteById(id);
    }
}
