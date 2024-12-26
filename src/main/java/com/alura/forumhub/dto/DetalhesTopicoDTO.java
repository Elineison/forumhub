package com.alura.forumhub.dto;

import com.alura.forumhub.model.Topico;
import com.alura.forumhub.model.Usuario;
import com.alura.forumhub.model.Curso;
import java.time.LocalDateTime;

public class DetalhesTopicoDTO {
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private String status;
    private AutorDTO autor;
    private CursoDTO curso;

    public DetalhesTopicoDTO(Topico topico) {
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
        this.status = topico.getStatus().name();
        this.autor = new AutorDTO(topico.getAutor());
        this.curso = new CursoDTO(topico.getCurso());
    }

    // DTOs internos para detalhamento
    public static class AutorDTO {
        private Long id;
        private String nome;
        private String email;

        public AutorDTO(Usuario autor) {
            this.id = autor.getId();
            this.nome = autor.getNome();
            this.email = autor.getEmail();
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

    public static class CursoDTO {
        private Long id;
        private String nome;
        private String categoria;

        public CursoDTO(Curso curso) {
            this.id = curso.getId();
            this.nome = curso.getNome();
            this.categoria = curso.getCategoria();
        }

        // Getters
        public Long getId() {
            return id;
        }

        public String getNome() {
            return nome;
        }

        public String getCategoria() {
            return categoria;
        }
    }

    // Getters para o DTO principal
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

    public AutorDTO getAutor() {
        return autor;
    }

    public CursoDTO getCurso() {
        return curso;
    }
}