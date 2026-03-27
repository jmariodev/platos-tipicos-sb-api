package com.ucompensar.platostipicossbapi.controller;

import com.ucompensar.platostipicossbapi.dto.UsuarioDto;
import com.ucompensar.platostipicossbapi.dto.UsuarioSaveDto;
import com.ucompensar.platostipicossbapi.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioDto> findAll() {
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioDto findById(@PathVariable Long id) {
        return usuarioService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDto save(@Valid @RequestBody UsuarioSaveDto usuarioDto) {
        return usuarioService.save(usuarioDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioDto update(@PathVariable Long id, @Valid @RequestBody UsuarioSaveDto usuarioDto) {
        return usuarioService.update(id, usuarioDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        usuarioService.delete(id);
    }
}
