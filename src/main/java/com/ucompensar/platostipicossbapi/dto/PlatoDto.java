package com.ucompensar.platostipicossbapi.dto;

import com.ucompensar.platostipicossbapi.entity.Plato;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlatoDto {

    private Long id;
    private String nombre;
    private int porciones;
    private boolean destacado;
    private int tiempoPreparacion;
    private String datoCurioso;
    private String historia;
    private String descripcion;
    
    private Long categoriaId;
    private String categoriaNombre;
    
    private Long departamentoId;
    private String departamentoNombre;
    
    private Long usuarioId;
    private String usuarioNombre;

    private List<IngredienteDto> ingredientes;
    private List<GaleriaDto> galeria;

    public static PlatoDto toDto(Plato plato) {
        return PlatoDto.builder()
                .id(plato.getId())
                .nombre(plato.getNombre())
                .porciones(plato.getPorciones())
                .destacado(plato.isDestacado())
                .tiempoPreparacion(plato.getTiempoPreparacion())
                .datoCurioso(plato.getDatoCurioso())
                .historia(plato.getHistoria())
                .descripcion(plato.getDescripcion())
                .categoriaId(plato.getCategoria().getId())
                .categoriaNombre(plato.getCategoria().getNombre())
                .departamentoId(plato.getDepartamento().getId())
                .departamentoNombre(plato.getDepartamento().getNombre())
                .usuarioId(plato.getUsuario().getId())
                .usuarioNombre(plato.getUsuario().getNombre())
                .ingredientes(plato.getIngredientes() != null ? 
                        plato.getIngredientes().stream().map(IngredienteDto::toDto).collect(Collectors.toList()) : null)
                .galeria(plato.getGaleria() != null ? 
                        plato.getGaleria().stream().map(GaleriaDto::toDto).collect(Collectors.toList()) : null)
                .build();
    }
}
