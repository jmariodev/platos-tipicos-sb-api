package com.ucompensar.platostipicossbapi.dto;

import com.ucompensar.platostipicossbapi.entity.Galeria;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GaleriaSaveDto {
    @NotBlank(message = "La URL de la imagen es obligatoria")
    private String url;
    private boolean esPrincipal;

    public Galeria toEntity() {
        Galeria galeria = new Galeria();
        galeria.setUrl(this.url);
        galeria.setEsPrincipal(this.esPrincipal);
        return galeria;
    }
}
