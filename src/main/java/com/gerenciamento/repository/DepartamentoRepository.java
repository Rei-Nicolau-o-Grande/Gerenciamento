package com.gerenciamento.repository;

import com.gerenciamento.model.Departamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

    Page<Departamento> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
}