package com.ucompensar.platostipicossbapi.controller;

import com.ucompensar.platostipicossbapi.dto.CategoriaDto;
import com.ucompensar.platostipicossbapi.dto.CategoriaSaveDto;
import com.ucompensar.platostipicossbapi.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CategoriaDto> findAll() {
        return categoriaService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoriaDto findById(@PathVariable Long id) {
        return categoriaService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoriaDto save(@Valid @RequestBody CategoriaSaveDto categoriaDto) {
        return categoriaService.save(categoriaDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoriaDto update(@PathVariable Long id, @Valid @RequestBody CategoriaSaveDto categoriaDto) {
        return categoriaService.update(id, categoriaDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        categoriaService.delete(id);
    }
}
