package com.ucompensar.platostipicossbapi.dto;

import com.ucompensar.platostipicossbapi.entity.Rol;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RolDto {

    private Long id;
    private String nombre;

    public static RolDto toDto(Rol rol){
        return RolDto.builder()
                .id(rol.getId())
                .nombre(rol.getNombre())
                .build();
    }
}
