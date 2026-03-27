package com.ucompensar.platostipicossbapi.dto;

import com.ucompensar.platostipicossbapi.entity.Comentario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComentarioSaveDto {
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    
    @NotBlank(message = "El comentario no puede estar vacío")
    private String comentario;
    
    @NotNull(message = "El ID del plato es obligatorio")
    private Long platoId;

    public Comentario toEntity() {
        Comentario entity = new Comentario();
        entity.setNombre(this.nombre);
        entity.setComentario(this.comentario);
        return entity;
    }
}
