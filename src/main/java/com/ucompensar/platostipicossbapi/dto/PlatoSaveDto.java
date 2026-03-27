package com.ucompensar.platostipicossbapi.dto;

import com.ucompensar.platostipicossbapi.entity.Plato;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlatoSaveDto {
    @NotBlank(message = "El nombre del plato es obligatorio")
    private String nombre;
    
    private int porciones;
    private boolean destacado;
    private int tiempoPreparacion;
    private String datoCurioso;
    private String historia;
    
    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;
    
    @NotNull(message = "El ID de la categoría es obligatorio")
    private Long categoriaId;
    
    @NotNull(message = "El ID del departamento es obligatorio")
    private Long departamentoId;
    
    @NotNull(message = "El ID del usuario es obligatorio")
    private Long usuarioId;
    
    private List<Long> ingredientesIds;
    
    private List<GaleriaSaveDto> galeria;

    public Plato toEntity() {
        Plato plato = new Plato();
        plato.setNombre(this.nombre);
        plato.setPorciones(this.porciones);
        plato.setDestacado(this.destacado);
        plato.setTiempoPreparacion(this.tiempoPreparacion);
        plato.setDatoCurioso(this.datoCurioso);
        plato.setHistoria(this.historia);
        plato.setDescripcion(this.descripcion);
        return plato;
    }
}
