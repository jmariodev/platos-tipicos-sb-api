package com.ucompensar.platostipicossbapi.controller;

import com.ucompensar.platostipicossbapi.dto.PlatoDto;
import com.ucompensar.platostipicossbapi.dto.PlatoSaveDto;
import com.ucompensar.platostipicossbapi.service.PlatoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/plato")
public class PlatoController {

    private final PlatoService platoService;

    public PlatoController(PlatoService platoService) {
        this.platoService = platoService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PlatoDto> findAll() {
        return platoService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PlatoDto findById(@PathVariable Long id) {
        return platoService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlatoDto save(@Valid @RequestBody PlatoSaveDto platoDto) {
        return platoService.save(platoDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PlatoDto update(@PathVariable Long id, @Valid @RequestBody PlatoSaveDto platoDto) {
        return platoService.update(id, platoDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        platoService.delete(id);
    }
}
