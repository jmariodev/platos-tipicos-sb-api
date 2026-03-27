package com.ucompensar.platostipicossbapi.service;

import com.ucompensar.platostipicossbapi.dto.DepartamentoDto;
import com.ucompensar.platostipicossbapi.dto.DepartamentoSaveDto;
import com.ucompensar.platostipicossbapi.entity.Departamento;
import com.ucompensar.platostipicossbapi.entity.Region;
import com.ucompensar.platostipicossbapi.repository.DepartamentoRepository;
import com.ucompensar.platostipicossbapi.repository.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {

    private final DepartamentoRepository departamentoRepository;
    private final RegionRepository regionRepository;

    public DepartamentoService(DepartamentoRepository departamentoRepository, RegionRepository regionRepository) {
        this.departamentoRepository = departamentoRepository;
        this.regionRepository = regionRepository;
    }

    public List<DepartamentoDto> findAll() {
        return departamentoRepository.findAll().stream().map(DepartamentoDto::toDto).toList();
    }

    public DepartamentoDto findById(Long id) {
        return departamentoRepository.findById(id)
                .map(DepartamentoDto::toDto)
                .orElseThrow(() -> new RuntimeException("Departamento con ID " + id + " no encontrado"));
    }

    public DepartamentoDto save(DepartamentoSaveDto departamentoDto) {
        Region region = regionRepository.findById(departamentoDto.getRegionId())
                .orElseThrow(() -> new RuntimeException("Región con ID " + departamentoDto.getRegionId() + " no encontrada"));
        
        Departamento departamento = departamentoDto.toEntity();
        departamento.setRegion(region);
        
        return DepartamentoDto.toDto(departamentoRepository.save(departamento));
    }

    public DepartamentoDto update(Long id, DepartamentoSaveDto departamentoDto) {
        Departamento departamento = departamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Departamento con ID " + id + " no encontrado"));

        Region region = regionRepository.findById(departamentoDto.getRegionId())
                .orElseThrow(() -> new RuntimeException("Región con ID " + departamentoDto.getRegionId() + " no encontrada"));

        departamento.setNombre(departamentoDto.getNombre());
        departamento.setRegion(region);

        return DepartamentoDto.toDto(departamentoRepository.save(departamento));
    }

    public void delete(Long id) {
        if (!departamentoRepository.existsById(id)) {
            throw new RuntimeException("Departamento con ID " + id + " no encontrado");
        }
        departamentoRepository.deleteById(id);
    }
}
