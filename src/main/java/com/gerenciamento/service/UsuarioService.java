package com.gerenciamento.service;

import com.gerenciamento.dto.departamento.DepartamentoDto;
import com.gerenciamento.dto.usuario.UsuarioRequest;
import com.gerenciamento.dto.usuario.UsuarioResponse;
import com.gerenciamento.model.Departamento;
import com.gerenciamento.model.Usuario;
import com.gerenciamento.repository.DepartamentoRepository;
import com.gerenciamento.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final DepartamentoRepository departamentoRepository;
    private final DepartamentoService departamentoService;

    public UsuarioService(UsuarioRepository usuarioRepository,
                          DepartamentoRepository departamentoRepository,
                          DepartamentoService departamentoService) {
        this.usuarioRepository = usuarioRepository;
        this.departamentoRepository = departamentoRepository;
        this.departamentoService = departamentoService;
    }

    public void create(UsuarioRequest usuarioRequest) {
        Departamento departamento = this.departamentoRepository
                                    .getReferenceById(usuarioRequest.departamentoId());

        this.departamentoService.findById(usuarioRequest.departamentoId());

        Usuario usuario = new Usuario(usuarioRequest, departamento);
        usuarioRepository.save(usuario);
    }

    public UsuarioResponse findById(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return new UsuarioResponse(usuario.getId(), usuario.getNome(), usuario.getEmail(),
                new DepartamentoDto(usuario.getDepartamento().getId(), usuario.getDepartamento().getNome()));
    }
}
