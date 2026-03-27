package com.ucompensar.platostipicossbapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequestDto {
    @NotBlank(message = "El usuario es obligatorio")
    private String usuario;
    
    @NotBlank(message = "La contraseña es obligatoria")
    private String contrasena;
}
