package com.gerenciamento.service;

import com.gerenciamento.dto.usuario.UsuarioRequest;
import com.gerenciamento.model.Departamento;
import com.gerenciamento.model.Usuario;
import com.gerenciamento.repository.DepartamentoRepository;
import com.gerenciamento.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final DepartamentoRepository departamentoRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, DepartamentoRepository departamentoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.departamentoRepository = departamentoRepository;
    }

    public void create(UsuarioRequest usuarioRequest) {
        Departamento departamento = this.departamentoRepository
                                    .getReferenceById(usuarioRequest.departamentoId());
        Usuario usuario = new Usuario(usuarioRequest, departamento);
        usuarioRepository.save(usuario);
    }
}
