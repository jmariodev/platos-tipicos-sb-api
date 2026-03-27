package com.ucompensar.platostipicossbapi.controller;

import com.ucompensar.platostipicossbapi.dto.RegionDto;
import com.ucompensar.platostipicossbapi.dto.RegionSaveDto;
import com.ucompensar.platostipicossbapi.service.RegionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/region")
public class RegionController {

    private final RegionService regionService;

    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RegionDto> findAll() {
        return regionService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RegionDto findById(@PathVariable Long id) {
        return regionService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RegionDto save(@Valid @RequestBody RegionSaveDto regionDto) {
        return regionService.save(regionDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RegionDto update(@PathVariable Long id, @Valid @RequestBody RegionSaveDto regionDto) {
        return regionService.update(id, regionDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        regionService.delete(id);
    }
}
