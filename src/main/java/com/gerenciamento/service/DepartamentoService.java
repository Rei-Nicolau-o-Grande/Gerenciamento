package com.gerenciamento.service;

import com.gerenciamento.dto.departamento.DepartamentoDto;
import com.gerenciamento.exception.base.EntityNotFound;
import com.gerenciamento.model.Departamento;
import com.gerenciamento.repository.DepartamentoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Transactional(readOnly = true)
    public Page<DepartamentoDto> findAllDepartamentos(String nome, Pageable pageable) {

        if (nome == null || nome.isEmpty())
            return departamentoRepository.findAll(pageable)
                    .map(departamento -> new DepartamentoDto(departamento.getId(), departamento.getNome()));

        return departamentoRepository.findByNomeContainingIgnoreCase(nome, pageable)
                .map(departamento -> new DepartamentoDto(departamento.getId(), departamento.getNome()));
    }
}
