package com.alura.forumhub.controller;

import com.alura.forumhub.dto.CadastroUsuarioDTO;
import com.alura.forumhub.dto.DetalhesUsuarioDTO;
import com.alura.forumhub.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<DetalhesUsuarioDTO> cadastrarUsuario(
            @RequestBody @Valid CadastroUsuarioDTO dto,
            UriComponentsBuilder uriBuilder
    ) {
        DetalhesUsuarioDTO usuario = usuarioService.cadastrarUsuario(dto);

        return ResponseEntity.created(
                uriBuilder.path("/usuarios/{id}")
                        .buildAndExpand(usuario.getId())
                        .toUri()
        ).body(usuario);
    }
}