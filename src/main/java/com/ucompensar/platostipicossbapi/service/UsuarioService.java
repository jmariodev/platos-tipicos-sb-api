package com.ucompensar.platostipicossbapi.service;

import com.ucompensar.platostipicossbapi.dto.UsuarioDto;
import com.ucompensar.platostipicossbapi.dto.UsuarioSaveDto;
import com.ucompensar.platostipicossbapi.entity.Rol;
import com.ucompensar.platostipicossbapi.entity.Usuario;
import com.ucompensar.platostipicossbapi.repository.RolRepository;
import com.ucompensar.platostipicossbapi.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, RolRepository rolRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UsuarioDto> findAll() {
        return usuarioRepository.findAll().stream().map(UsuarioDto::toDto).toList();
    }

    public UsuarioDto findById(Long id) {
        return usuarioRepository.findById(id)
                .map(UsuarioDto::toDto)
                .orElseThrow(() -> new RuntimeException("Usuario con ID " + id + " no encontrado"));
    }

    public UsuarioDto save(UsuarioSaveDto usuarioDto) {
        Usuario usuario = usuarioDto.toEntity();

        usuario.setContrasena(passwordEncoder.encode(usuarioDto.getContrasena()));
        
        List<Rol> roles = rolRepository.findAllById(usuarioDto.getRolesIds());
        if(roles.isEmpty()){
             throw new RuntimeException("Debe asignar roles válidos al usuario");
        }
        usuario.setRoles(roles);
        
        return UsuarioDto.toDto(usuarioRepository.save(usuario));
    }

    public UsuarioDto update(Long id, UsuarioSaveDto usuarioDto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario con ID " + id + " no encontrado"));

        usuario.setNombre(usuarioDto.getNombre());
        usuario.setUsuario(usuarioDto.getUsuario());
        usuario.setEstado(usuarioDto.isEstado());
        
        // Si se envía una nueva contraseña, se encripta
        if (usuarioDto.getContrasena() != null && !usuarioDto.getContrasena().isBlank()) {
            usuario.setContrasena(passwordEncoder.encode(usuarioDto.getContrasena()));
        }

        List<Rol> roles = rolRepository.findAllById(usuarioDto.getRolesIds());
        if(!roles.isEmpty()){
            usuario.setRoles(roles);
        }

        return UsuarioDto.toDto(usuarioRepository.save(usuario));
    }

    public void delete(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuario con ID " + id + " no encontrado");
        }
        usuarioRepository.deleteById(id);
    }
}
