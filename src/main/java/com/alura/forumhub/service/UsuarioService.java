package com.alura.forumhub.service;

import com.alura.forumhub.dto.CadastroUsuarioDTO;
import com.alura.forumhub.dto.DetalhesUsuarioDTO;
import com.alura.forumhub.model.Usuario;
import com.alura.forumhub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public DetalhesUsuarioDTO cadastrarUsuario(CadastroUsuarioDTO dto) {
        // Verificar se o email já existe
        usuarioRepository.findByEmail(dto.getEmail())
                .ifPresent(u -> {
                    throw new IllegalArgumentException("Já existe um usuário com este email");
                });

        // Criar novo usuário
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());

        // Criptografar senha
        usuario.setSenha(passwordEncoder.encode(dto.getSenha()));

        // Salvar usuário
        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        // Retornar DTO de detalhes
        return new DetalhesUsuarioDTO(usuarioSalvo);
    }
}