package com.alura.forumhub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AtualizacaoTopicoDTO {
    @NotBlank(message = "Título é obrigatório")
    @Size(min = 5, max = 100, message = "Título deve ter entre 5 e 100 caracteres")
    private String titulo;

    @NotBlank(message = "Mensagem é obrigatória")
    @Size(min = 10, max = 1000, message = "Mensagem deve ter entre 10 e 1000 caracteres")
    private String mensagem;

    // Construtores
    public AtualizacaoTopicoDTO() {}

    public AtualizacaoTopicoDTO(String titulo, String mensagem) {
        this.titulo = titulo;
        this.mensagem = mensagem;
    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    // Setters
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}