package br.com.alura.forum.controller;

import br.com.alura.forum.domain.usuario.dto.DadosUsuario;
import br.com.alura.forum.domain.usuario.dto.DetalhamentoUsuario;
import br.com.alura.forum.domain.usuario.service.UsuarioServise;
import br.com.alura.forum.domain.usuario.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioServise usuarioServise;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    @PostMapping
    public ResponseEntity<?> criarUsuario(@Valid @RequestBody DetalhamentoUsuario dados) {

        if (usuarioRepository.existsByEmailAndSenha(dados.email(),dados.senha())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuario já cadastrado");
        }

        usuarioServise.saveUsuario(dados);

        return ResponseEntity.status(200).body(new DadosUsuario(dados.nome(), dados.email()));
    }
}
