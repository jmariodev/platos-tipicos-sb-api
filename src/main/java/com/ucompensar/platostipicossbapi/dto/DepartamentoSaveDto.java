package com.ucompensar.platostipicossbapi.dto;

import com.ucompensar.platostipicossbapi.entity.Departamento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartamentoSaveDto {
    @NotBlank(message = "El nombre del departamento es obligatorio")
    private String nombre;
    
    @NotNull(message = "El ID de la región es obligatorio")
    private Long regionId;

    public Departamento toEntity() {
        Departamento departamento = new Departamento();
        departamento.setNombre(this.nombre);
        return departamento;
    }
}
