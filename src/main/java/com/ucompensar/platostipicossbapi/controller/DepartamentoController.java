package com.ucompensar.platostipicossbapi.controller;

import com.ucompensar.platostipicossbapi.dto.DepartamentoDto;
import com.ucompensar.platostipicossbapi.dto.DepartamentoSaveDto;
import com.ucompensar.platostipicossbapi.service.DepartamentoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/departamento")
public class DepartamentoController {

    private final DepartamentoService departamentoService;

    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DepartamentoDto> findAll() {
        return departamentoService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DepartamentoDto findById(@PathVariable Long id) {
        return departamentoService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DepartamentoDto save(@Valid @RequestBody DepartamentoSaveDto departamentoDto) {
        return departamentoService.save(departamentoDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DepartamentoDto update(@PathVariable Long id, @Valid @RequestBody DepartamentoSaveDto departamentoDto) {
        return departamentoService.update(id, departamentoDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        departamentoService.delete(id);
    }
}
