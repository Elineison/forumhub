package com.alura.forumhub.repository;

import com.alura.forumhub.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    // Métodos de consulta personalizados podem ser adicionados aqui
}