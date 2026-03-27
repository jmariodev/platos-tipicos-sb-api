package com.ucompensar.platostipicossbapi.dto;

import com.ucompensar.platostipicossbapi.entity.Ingrediente;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IngredienteDto {

    private Long id;
    private String nombre;

    public static IngredienteDto toDto(Ingrediente ingrediente) {

        return IngredienteDto.builder()
                .id(ingrediente.getId())
                .nombre(ingrediente.getNombre())
                .build();
    }
}
