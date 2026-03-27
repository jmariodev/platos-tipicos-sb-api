package com.ucompensar.platostipicossbapi.dto;

import com.ucompensar.platostipicossbapi.entity.Galeria;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GaleriaDto {
    private Long id;
    private String url;
    private boolean esPrincipal;

    public static GaleriaDto toDto(Galeria galeria) {
        return GaleriaDto.builder()
                .id(galeria.getId())
                .url(galeria.getUrl())
                .esPrincipal(galeria.isEsPrincipal())
                .build();
    }
}
