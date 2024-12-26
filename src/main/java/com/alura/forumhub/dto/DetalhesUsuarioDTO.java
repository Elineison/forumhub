package com.alura.forumhub.dto;

import com.alura.forumhub.model.Usuario;

public class DetalhesUsuarioDTO {
    private Long id;
    private String nome;
    private String email;

    public DetalhesUsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}