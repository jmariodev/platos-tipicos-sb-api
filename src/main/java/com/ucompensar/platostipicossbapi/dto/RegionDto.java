package com.ucompensar.platostipicossbapi.dto;

import com.ucompensar.platostipicossbapi.entity.Region;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegionDto {

    private Long id;
    private String nombre;
    private String descripcion;
    private String imagen;
    private String color;

    public static RegionDto toDto(Region region){
        return RegionDto.builder()
                .id(region.getId())
                .nombre(region.getNombre())
                .descripcion(region.getDescripcion())
                .imagen(region.getImagen())
                .color(region.getColor())
                .build();
    }
}
