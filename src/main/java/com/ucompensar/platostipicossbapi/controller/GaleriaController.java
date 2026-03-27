package com.ucompensar.platostipicossbapi.controller;

import com.ucompensar.platostipicossbapi.dto.GaleriaDto;
import com.ucompensar.platostipicossbapi.dto.GaleriaSaveDto;
import com.ucompensar.platostipicossbapi.service.GaleriaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/galeria")
public class GaleriaController {

    private final GaleriaService galeriaService;

    public GaleriaController(GaleriaService galeriaService) {
        this.galeriaService = galeriaService;
    }

    @GetMapping
    public List<GaleriaDto> findAll() {
        return galeriaService.findAll();
    }

    @PostMapping("/plato/{platoId}")
    @ResponseStatus(HttpStatus.CREATED)
    public GaleriaDto save(@PathVariable Long platoId, @Valid @RequestBody GaleriaSaveDto dto) {
        return galeriaService.save(platoId, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        galeriaService.delete(id);
    }
}
