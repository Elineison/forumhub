package com.alura.forumhub.repository;

import com.alura.forumhub.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
    // Método para verificar tópicos duplicados
    Optional<Topico> findByTituloAndMensagem(String titulo, String mensagem);
}