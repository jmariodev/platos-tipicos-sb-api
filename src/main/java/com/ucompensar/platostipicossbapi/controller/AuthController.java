package com.ucompensar.platostipicossbapi.controller;

import com.ucompensar.platostipicossbapi.dto.LoginRequestDto;
import com.ucompensar.platostipicossbapi.dto.LoginResponseDto;
import com.ucompensar.platostipicossbapi.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponseDto login(@Valid @RequestBody LoginRequestDto loginRequest) {
        return usuarioService.login(loginRequest);
    }
}
