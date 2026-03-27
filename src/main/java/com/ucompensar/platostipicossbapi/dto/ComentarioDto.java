package com.ucompensar.platostipicossbapi.dto;

import com.ucompensar.platostipicossbapi.entity.Comentario;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComentarioDto {
    private Long id;
    private String nombre;
    private String comentario;
    private LocalDateTime fecha;
    private Long platoId;

    public static ComentarioDto toDto(Comentario comentario) {
        return ComentarioDto.builder()
                .id(comentario.getId())
                .nombre(comentario.getNombre())
                .comentario(comentario.getComentario())
                .fecha(comentario.getFecha())
                .platoId(comentario.getPlato().getId())
                .build();
    }
}
