package com.gerenciamento.dto.usuario;

import com.gerenciamento.dto.departamento.DepartamentoDto;

public record UsuarioResponse(

            Long id,
            String nome,
            String email,
            DepartamentoDto departamento
) {
}
