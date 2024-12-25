package com.alura.forumhub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CadastroTopicoDTO {
    @NotBlank(message = "Título é obrigatório")
    private String titulo;

    @NotBlank(message = "Mensagem é obrigatória")
    private String mensagem;

    @NotNull(message = "Curso é obrigatório")
    private Long cursoId;

    @NotNull(message = "Autor é obrigatório")
    private Long autorId;

    // Construtor padrão
    public CadastroTopicoDTO() {}

    // Construtor com todos os campos
    public CadastroTopicoDTO(String titulo, String mensagem, Long cursoId, Long autorId) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.cursoId = cursoId;
        this.autorId = autorId;
    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public Long getAutorId() {
        return autorId;
    }

    // Setters
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }
}