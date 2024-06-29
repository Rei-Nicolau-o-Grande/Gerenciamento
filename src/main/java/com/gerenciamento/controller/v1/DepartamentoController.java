package com.gerenciamento.controller.v1;

import com.gerenciamento.dto.departamento.DepartamentoDto;
import com.gerenciamento.service.DepartamentoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/departamentos")
public class DepartamentoController {

    public final DepartamentoService departamentoService;

    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid DepartamentoDto departamentoDto) {
        this.departamentoService.create(departamentoDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
