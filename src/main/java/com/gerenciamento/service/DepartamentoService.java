package com.gerenciamento.service;

import com.gerenciamento.dto.departamento.DepartamentoDto;
import com.gerenciamento.exception.base.EntityNotFound;
import com.gerenciamento.model.Departamento;
import com.gerenciamento.repository.DepartamentoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartamentoService {

    private final DepartamentoRepository departamentoRepository;

    public DepartamentoService(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    @Transactional
    public void create(DepartamentoDto departamentoDto) {
        Departamento departamento = new Departamento(departamentoDto);
        this.departamentoRepository.save(departamento);
    }

    @Transactional
    public void update(Long id, DepartamentoDto departamentoDto) {
        Departamento departamento = departamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFound("Departamento não encontrado"));
        departamento.setNome(departamentoDto.nome());
        departamentoRepository.save(departamento);
    }

    @Transactional(readOnly = true)
    public DepartamentoDto findById(Long id) {
        Departamento departamento = departamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFound("Departamento não encontrado"));
        return new DepartamentoDto(departamento.getId(), departamento.getNome());
    }

    @Transactional
    public void delete(Long id) {
        Departamento departamento = departamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFound("Departamento não encontrado"));
        departamentoRepository.delete(departamento);
    }
}
