package com.ucompensar.platostipicossbapi.service;

import com.ucompensar.platostipicossbapi.dto.RegionDto;
import com.ucompensar.platostipicossbapi.dto.RegionSaveDto;
import com.ucompensar.platostipicossbapi.entity.Region;
import com.ucompensar.platostipicossbapi.repository.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {

    private final RegionRepository regionRepository;

    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public List<RegionDto> findAll() {
        return regionRepository.findAll().stream().map(RegionDto::toDto).toList();
    }

    public RegionDto findById(Long id) {
        return regionRepository.findById(id)
                .map(RegionDto::toDto)
                .orElseThrow(() -> new RuntimeException("Región con ID " + id + " no encontrada"));
    }

    public RegionDto save(RegionSaveDto regionDto) {
        Region region = regionDto.toEntity();
        return RegionDto.toDto(regionRepository.save(region));
    }

    public RegionDto update(Long id, RegionSaveDto regionDto) {
        Region region = regionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Región con ID " + id + " no encontrada"));

        region.setNombre(regionDto.getNombre());
        region.setDescripcion(regionDto.getDescripcion());
        region.setImagen(regionDto.getImagen());
        region.setColor(regionDto.getColor());

        return RegionDto.toDto(regionRepository.save(region));
    }

    public void delete(Long id) {
        if (!regionRepository.existsById(id)) {
            throw new RuntimeException("Región con ID " + id + " no encontrada");
        }
        regionRepository.deleteById(id);
    }
}
