package com.alura.forumhub.service;

import com.alura.forumhub.dto.CadastroTopicoDTO;
import com.alura.forumhub.dto.DetalhesTopicoDTO;
import com.alura.forumhub.model.Curso;
import com.alura.forumhub.model.Topico;
import com.alura.forumhub.model.Usuario;
import com.alura.forumhub.repository.CursoRepository;
import com.alura.forumhub.repository.TopicoRepository;
import com.alura.forumhub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Transactional
    public Topico criarTopico(CadastroTopicoDTO dto) {
        // Validar usuário
        Usuario autor = usuarioRepository.findById(dto.getAutorId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        // Validar curso
        Curso curso = cursoRepository.findById(dto.getCursoId())
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        // Criar novo tópico
        Topico topico = new Topico();
        topico.setTitulo(dto.getTitulo());
        topico.setMensagem(dto.getMensagem());
        topico.setAutor(autor);
        topico.setCurso(curso);

        // Salvar tópico
        return topicoRepository.save(topico);
    }

    @Transactional(readOnly = true)
    public List<Topico> listarTopicos() {
        return topicoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Topico buscarTopicoPorId(Long id) {
        return topicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tópico não encontrado"));
    }

    // Métodos adicionais mantidos como estavam
}