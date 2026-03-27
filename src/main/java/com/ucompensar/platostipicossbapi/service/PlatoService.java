package com.ucompensar.platostipicossbapi.service;

import com.ucompensar.platostipicossbapi.dto.PlatoDto;
import com.ucompensar.platostipicossbapi.dto.PlatoSaveDto;
import com.ucompensar.platostipicossbapi.entity.*;
import com.ucompensar.platostipicossbapi.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlatoService {

    private final PlatoRepository platoRepository;
    private final CategoriaRepository categoriaRepository;
    private final DepartamentoRepository departamentoRepository;
    private final UsuarioRepository usuarioRepository;
    private final IngredienteRepository ingredienteRepository;

    public PlatoService(PlatoRepository platoRepository, 
                        CategoriaRepository categoriaRepository, 
                        DepartamentoRepository departamentoRepository, 
                        UsuarioRepository usuarioRepository, 
                        IngredienteRepository ingredienteRepository) {
        this.platoRepository = platoRepository;
        this.categoriaRepository = categoriaRepository;
        this.departamentoRepository = departamentoRepository;
        this.usuarioRepository = usuarioRepository;
        this.ingredienteRepository = ingredienteRepository;
    }

    public List<PlatoDto> findAll() {
        return platoRepository.findAll().stream().map(PlatoDto::toDto).toList();
    }

    public PlatoDto findById(Long id) {
        return platoRepository.findById(id)
                .map(PlatoDto::toDto)
                .orElseThrow(() -> new RuntimeException("Plato con ID " + id + " no encontrado"));
    }

    @Transactional
    public PlatoDto save(PlatoSaveDto dto) {
        Plato plato = dto.toEntity();
        
        // Cargar Relaciones
        plato.setCategoria(categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada")));
        
        plato.setDepartamento(departamentoRepository.findById(dto.getDepartamentoId())
                .orElseThrow(() -> new RuntimeException("Departamento no encontrado")));
        
        plato.setUsuario(usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado")));

        // Cargar Ingredientes (Selección múltiple de maestro)
        if (dto.getIngredientesIds() != null && !dto.getIngredientesIds().isEmpty()) {
            List<Ingrediente> ingredientes = ingredienteRepository.findAllById(dto.getIngredientesIds());
            plato.setIngredientes(ingredientes);
        }

        // Cargar Galería (Embebida)
        if (dto.getGaleria() != null && !dto.getGaleria().isEmpty()) {
            List<Galeria> galeriaItems = dto.getGaleria().stream()
                    .map(gDto -> {
                        Galeria g = gDto.toEntity();
                        g.setPlato(plato);
                        return g;
                    }).collect(Collectors.toList());
            plato.setGaleria(galeriaItems);
        }

        return PlatoDto.toDto(platoRepository.save(plato));
    }

    @Transactional
    public PlatoDto update(Long id, PlatoSaveDto dto) {
        Plato plato = platoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plato no encontrado"));

        plato.setNombre(dto.getNombre());
        plato.setPorciones(dto.getPorciones());
        plato.setDestacado(dto.isDestacado());
        plato.setTiempoPreparacion(dto.getTiempoPreparacion());
        plato.setDatoCurioso(dto.getDatoCurioso());
        plato.setHistoria(dto.getHistoria());
        plato.setDescripcion(dto.getDescripcion());

        plato.setCategoria(categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada")));
        
        plato.setDepartamento(departamentoRepository.findById(dto.getDepartamentoId())
                .orElseThrow(() -> new RuntimeException("Departamento no encontrado")));

        // Actualizar Ingredientes
        if (dto.getIngredientesIds() != null) {
            List<Ingrediente> ingredientes = ingredienteRepository.findAllById(dto.getIngredientesIds());
            plato.setIngredientes(ingredientes);
        }

        // Actualizar Galería (Reemplazo total para simplificar)
        if (dto.getGaleria() != null) {
            plato.getGaleria().clear();
            List<Galeria> nuevasImagenes = dto.getGaleria().stream()
                    .map(gDto -> {
                        Galeria g = gDto.toEntity();
                        g.setPlato(plato);
                        return g;
                    }).toList();
            plato.getGaleria().addAll(nuevasImagenes);
        }

        return PlatoDto.toDto(platoRepository.save(plato));
    }

    public void delete(Long id) {
        if (!platoRepository.existsById(id)) {
            throw new RuntimeException("Plato no encontrado");
        }
        platoRepository.deleteById(id);
    }
}
