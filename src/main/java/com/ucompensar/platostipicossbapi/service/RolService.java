package com.ucompensar.platostipicossbapi.service;

import com.ucompensar.platostipicossbapi.dto.RolDto;
import com.ucompensar.platostipicossbapi.entity.Rol;
import com.ucompensar.platostipicossbapi.repository.RolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {

    private final RolRepository rolRepository;

    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    public List<RolDto> findAll() {
        return rolRepository.findAll().stream().map(RolDto::toDto).toList();
    }

    public RolDto save(Rol rol) {
        return RolDto.toDto(rolRepository.save(rol));
    }
}
