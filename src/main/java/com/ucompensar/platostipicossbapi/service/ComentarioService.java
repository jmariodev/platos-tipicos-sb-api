package com.ucompensar.platostipicossbapi.service;

import com.ucompensar.platostipicossbapi.dto.ComentarioDto;
import com.ucompensar.platostipicossbapi.dto.ComentarioSaveDto;
import com.ucompensar.platostipicossbapi.entity.Comentario;
import com.ucompensar.platostipicossbapi.entity.Plato;
import com.ucompensar.platostipicossbapi.repository.ComentarioRepository;
import com.ucompensar.platostipicossbapi.repository.PlatoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;
    private final PlatoRepository platoRepository;

    public ComentarioService(ComentarioRepository comentarioRepository, PlatoRepository platoRepository) {
        this.comentarioRepository = comentarioRepository;
        this.platoRepository = platoRepository;
    }

    public List<ComentarioDto> findAll() {
        return comentarioRepository.findAll().stream().map(ComentarioDto::toDto).toList();
    }

    public List<ComentarioDto> findByPlatoId(Long platoId) {
        return comentarioRepository.findByPlatoId(platoId).stream().map(ComentarioDto::toDto).toList();
    }

    public ComentarioDto save(ComentarioSaveDto dto) {
        Plato plato = platoRepository.findById(dto.getPlatoId())
                .orElseThrow(() -> new RuntimeException("Plato no encontrado"));

        Comentario comentario = dto.toEntity();
        comentario.setPlato(plato);
        
        return ComentarioDto.toDto(comentarioRepository.save(comentario));
    }

    public void delete(Long id) {
        if (!comentarioRepository.existsById(id)) {
            throw new RuntimeException("Comentario no encontrado");
        }
        comentarioRepository.deleteById(id);
    }
}
