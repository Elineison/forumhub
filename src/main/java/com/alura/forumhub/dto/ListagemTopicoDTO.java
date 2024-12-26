package com.alura.forumhub.dto;

import com.alura.forumhub.model.Topico;
import java.time.LocalDateTime;

public class ListagemTopicoDTO {
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private String status;
    private String autorNome;
    private String cursoNome;

    public ListagemTopicoDTO(Topico topico) {
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
        this.status = topico.getStatus().name();
        this.autorNome = topico.getAutor().getNome();
        this.cursoNome = topico.getCurso().getNome();
    }

    // Getters (todos os campos)
    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public String getStatus() {
        return status;
    }

    public String getAutorNome() {
        return autorNome;
    }

    public String getCursoNome() {
        return cursoNome;
    }
}