package com.ucompensar.platostipicossbapi.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResponseDto {
    private String mensaje;
    private UsuarioDto usuario;
}
