package com.ucompensar.platostipicossbapi.dto;

import com.ucompensar.platostipicossbapi.entity.Categoria;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoriaSaveDto {
    @NotBlank(message = "El nombre de la categoría es obligatorio")
    private String nombre;

    public Categoria toEntity() {
        Categoria categoria = new Categoria();
        categoria.setNombre(this.nombre);
        return categoria;
    }
}
