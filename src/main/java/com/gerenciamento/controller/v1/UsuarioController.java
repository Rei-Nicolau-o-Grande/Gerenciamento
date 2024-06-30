package com.gerenciamento.controller.v1;

import com.gerenciamento.controller.docSwagger.usuarios.*;
import com.gerenciamento.dto.PaginationDto;
import com.gerenciamento.dto.usuario.UsuarioRequest;
import com.gerenciamento.dto.usuario.UsuarioResponse;
import com.gerenciamento.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @DocCreateUser
    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid UsuarioRequest dto) {
        this.usuarioService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DocUpdateUser
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid UsuarioRequest dto) {
        this.usuarioService.update(id, dto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DocFindByIdUser
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(this.usuarioService.findById(id));
    }

    @DocDeleteUser
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        this.usuarioService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DocPaginationUser
    @GetMapping
    public ResponseEntity<PaginationDto<UsuarioResponse>> findAllPagination(@RequestParam(value = "nome" , required = false) String nome,
                                                            Pageable pageable) {
        var usuarios = this.usuarioService.findAllUsuarios(nome, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(new PaginationDto<>(
                usuarios.getContent(),
                usuarios.getNumber(),
                usuarios.getSize(),
                usuarios.getTotalPages(),
                usuarios.getTotalElements()
        ));
    }
}
