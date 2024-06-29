package com.gerenciamento.service;

import com.gerenciamento.dto.departamento.DepartamentoDto;
import com.gerenciamento.exception.base.EntityNotFound;
import com.gerenciamento.model.Departamento;
import com.gerenciamento.repository.DepartamentoRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartamentoService {

    private final DepartamentoRepository departamentoRepository;

    public DepartamentoService(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    public void create(DepartamentoDto departamentoDto) {
        Departamento departamento = new Departamento(departamentoDto);
        this.departamentoRepository.save(departamento);
    }

    public DepartamentoDto findById(Long id) {
        Departamento departamento = departamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFound("Departamento não encontrado"));
        return new DepartamentoDto(departamento.getId(), departamento.getNome());
    }
}
