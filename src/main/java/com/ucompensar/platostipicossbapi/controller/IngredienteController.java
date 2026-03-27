package com.ucompensar.platostipicossbapi.controller;

import com.ucompensar.platostipicossbapi.dto.IngredienteDto;
import com.ucompensar.platostipicossbapi.dto.IngredienteSaveDto;
import com.ucompensar.platostipicossbapi.service.IngredienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/ingrediente")
public class IngredienteController {

    private final IngredienteService ingredienteService;

    public IngredienteController(IngredienteService ingredienteService) {
        this.ingredienteService = ingredienteService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<IngredienteDto> findAll() {
        return ingredienteService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public IngredienteDto findById(@PathVariable Long id) {
        return ingredienteService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IngredienteDto save(@Valid @RequestBody IngredienteSaveDto ingredienteDto) {
        return ingredienteService.save(ingredienteDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public IngredienteDto update(@PathVariable Long id, @Valid @RequestBody IngredienteSaveDto ingredienteDto) {
        return ingredienteService.update(id, ingredienteDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        ingredienteService.delete(id);
    }
}
