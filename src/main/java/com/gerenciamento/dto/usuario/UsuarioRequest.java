package com.gerenciamento.dto.usuario;

public record UsuarioRequest(

        String nome,
        String email,
        Long departamentoId) {
}
