package com.gerenciamento.controller.v1;

import com.gerenciamento.dto.usuario.UsuarioRequest;
import com.gerenciamento.dto.usuario.UsuarioResponse;
import com.gerenciamento.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid UsuarioRequest dto) {
        this.usuarioService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
