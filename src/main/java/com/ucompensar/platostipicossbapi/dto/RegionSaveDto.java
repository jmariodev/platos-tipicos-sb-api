package com.ucompensar.platostipicossbapi.dto;

import com.ucompensar.platostipicossbapi.entity.Region;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegionSaveDto {
    @NotBlank(message = "El nombre de la región es obligatorio")
    private String nombre;
    
    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;
    
    private String imagen;
    private String color;

    public Region toEntity() {
        Region region = new Region();
        region.setNombre(this.nombre);
        region.setDescripcion(this.descripcion);
        region.setImagen(this.imagen);
        region.setColor(this.color);
        return region;
    }
}
