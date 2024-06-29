package com.gerenciamento.model;

import com.gerenciamento.dto.departamento.DepartamentoDto;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "departamentos")
public class Departamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nome;

    @OneToMany(mappedBy = "departamento")
    private List<Usuario> usuarios;

    public Departamento() {
    }

    public Departamento(DepartamentoDto departamentoDto) {
        this.nome = departamentoDto.nome();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departamento that = (Departamento) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(usuarios, that.usuarios);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, usuarios);
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
