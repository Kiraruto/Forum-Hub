package br.com.alura.forum.domain.usuario.service;

import br.com.alura.forum.domain.usuario.Usuario;
import br.com.alura.forum.domain.usuario.dto.DetalhamentoUsuario;
import br.com.alura.forum.domain.usuario.repository.UsuarioRepository;
import br.com.alura.forum.domain.perfil.Perfil;
import br.com.alura.forum.domain.perfil.repositorio.PerfilRepositorio;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServise {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PerfilRepositorio perfilRepositoriy;

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void saveUsuario(DetalhamentoUsuario dados) {

        Usuario usuario = new Usuario(dados);
        Perfil perfil = new Perfil(dados);

        usuarioRepository.save(usuario);
        entityManager.merge(perfil);
        perfilRepositoriy.save(perfil);

    }
}
