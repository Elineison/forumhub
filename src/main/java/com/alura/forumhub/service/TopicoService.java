package com.alura.forumhub.service;

import com.alura.forumhub.exception.ResourceNotFoundException;
import com.alura.forumhub.model.Topico;
import com.alura.forumhub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository topicoRepository;

    // Método para excluir tópico
    @Transactional
    public void excluirTopico(Long id) {
        // Verificar se o tópico existe
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tópico não encontrado com ID: " + id));

        // Excluir tópico
        topicoRepository.delete(topico);
    }
}