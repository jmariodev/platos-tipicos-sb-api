package com.ucompensar.platostipicossbapi.controller;

import com.ucompensar.platostipicossbapi.dto.RolDto;
import com.ucompensar.platostipicossbapi.entity.Rol;
import com.ucompensar.platostipicossbapi.service.RolService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rol")
public class RolController {

    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping
    public List<RolDto> findAll() {
        return rolService.findAll();
    }

    @PostMapping
    public RolDto save(@RequestBody Rol rol) {
        return rolService.save(rol);
    }
}
