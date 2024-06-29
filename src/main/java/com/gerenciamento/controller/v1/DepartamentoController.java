package com.gerenciamento.controller.v1;

import com.gerenciamento.dto.departamento.DepartamentoDto;
import com.gerenciamento.service.DepartamentoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid DepartamentoDto departamentoDto) {
        this.departamentoService.update(id, departamentoDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(this.departamentoService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        this.departamentoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
