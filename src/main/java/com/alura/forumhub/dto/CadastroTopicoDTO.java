package com.alura.forumhub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CadastroTopicoDTO {
    @NotBlank(message = "Título é obrigatório")
    @Size(min = 5, max = 100, message = "Título deve ter entre 5 e 100 caracteres")
    private String titulo;

    @NotBlank(message = "Mensagem é obrigatória")
    @Size(min = 10, max = 1000, message = "Mensagem deve ter entre 10 e 1000 caracteres")
    private String mensagem;

    @NotNull(message = "ID do autor é obrigatório")
    private Long autorId;

    @NotNull(message = "ID do curso é obrigatório")
    private Long cursoId;

    // Construtores
    public CadastroTopicoDTO() {}

    public CadastroTopicoDTO(String titulo, String mensagem, Long autorId, Long cursoId) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.autorId = autorId;
        this.cursoId = cursoId;
    }

    // GETTERS - Certifique-se de que TODOS estão presentes
    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public Long getAutorId() {
        return autorId;
    }

    public Long getCursoId() {
        return cursoId;
    }

    // SETTERS
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }
}