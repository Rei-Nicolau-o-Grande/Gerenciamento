package com.gerenciamento.model;

import com.gerenciamento.dto.usuario.UsuarioRequest;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false, length = 100)
    private String email;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Departamento departamento;

    public Usuario(Long id, String nome, String email, Departamento departamento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.departamento = departamento;
    }

    public Usuario() {
    }

    public Usuario(UsuarioRequest usuarioRequest, Departamento departamento) {
        this.nome = usuarioRequest.nome();
        this.email = usuarioRequest.email();
        this.departamento = departamento;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id) && Objects.equals(nome, usuario.nome) && Objects.equals(email, usuario.email) && Objects.equals(departamento, usuario.departamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, departamento);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", departamento=" + departamento +
                '}';
    }
}
