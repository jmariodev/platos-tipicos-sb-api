package com.ucompensar.platostipicossbapi.controller;

import com.ucompensar.platostipicossbapi.dto.ComentarioDto;
import com.ucompensar.platostipicossbapi.dto.ComentarioSaveDto;
import com.ucompensar.platostipicossbapi.service.ComentarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/comentario")
public class ComentarioController {

    private final ComentarioService comentarioService;

    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ComentarioDto> findAll() {
        return comentarioService.findAll();
    }

    @GetMapping("/plato/{platoId}")
    @ResponseStatus(HttpStatus.OK)
    public List<ComentarioDto> findByPlatoId(@PathVariable Long platoId) {
        return comentarioService.findByPlatoId(platoId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ComentarioDto save(@Valid @RequestBody ComentarioSaveDto dto) {
        return comentarioService.save(dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        comentarioService.delete(id);
    }
}
