package com.ucompensar.platostipicossbapi.dto;

import com.ucompensar.platostipicossbapi.entity.Ingrediente;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IngredienteSaveDto {
    @NotBlank(message = "El nombre del ingrediente es obligatorio")
    private String nombre;

    public Ingrediente toEntity() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNombre(this.nombre);
        return ingrediente;
    }
}
