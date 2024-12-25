package com.alura.forumhub.controller;

import com.alura.forumhub.dto.CadastroTopicoDTO;
import com.alura.forumhub.dto.DetalhesTopicoDTO;
import com.alura.forumhub.model.Topico;
import com.alura.forumhub.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    public ResponseEntity<DetalhesTopicoDTO> criarTopico(
            @RequestBody @Valid CadastroTopicoDTO dto,
            UriComponentsBuilder uriBuilder
    ) {
        Topico topico = topicoService.criarTopico(dto);
        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesTopicoDTO(topico));
    }

    @GetMapping
    public ResponseEntity<List<DetalhesTopicoDTO>> listarTopicos() {
        List<Topico> topicos = topicoService.listarTopicos();
        List<DetalhesTopicoDTO> topicosDTO = topicos.stream()
                .map(DetalhesTopicoDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(topicosDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesTopicoDTO> detalharTopico(@PathVariable Long id) {
        Topico topico = topicoService.buscarTopicoPorId(id);
        return ResponseEntity.ok(new DetalhesTopicoDTO(topico));
    }

    // Outros métodos mantidos como estavam
}