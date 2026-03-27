package com.ucompensar.platostipicossbapi.dto;

import com.ucompensar.platostipicossbapi.entity.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioSaveDto {
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    
    @NotBlank(message = "El usuario es obligatorio")
    private String usuario;
    
    @NotBlank(message = "La contraseña es obligatoria")
    private String contrasena;
    
    private boolean estado = true;
    
    @NotEmpty(message = "Debe asignar al menos un rol")
    private List<Long> rolesIds;

    public Usuario toEntity() {
        Usuario usuarioEntity = new Usuario();
        usuarioEntity.setNombre(this.nombre);
        usuarioEntity.setUsuario(this.usuario);
        usuarioEntity.setContrasena(this.contrasena);
        usuarioEntity.setEstado(this.estado);
        return usuarioEntity;
    }
}
