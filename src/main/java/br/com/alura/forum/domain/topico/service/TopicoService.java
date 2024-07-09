package br.com.alura.forum.domain.topico.service;

import br.com.alura.forum.domain.Curso.repositorio.CursoRepository;
import br.com.alura.forum.domain.usuario.repository.UsuarioRepository;
import br.com.alura.forum.domain.perfil.Perfil;
import br.com.alura.forum.domain.perfil.repositorio.PerfilRepositorio;
import br.com.alura.forum.domain.resposta.repositorio.RespostaRepository;
import br.com.alura.forum.domain.topico.Topico;
import br.com.alura.forum.domain.topico.dto.DetalhamentoTopico;
import br.com.alura.forum.domain.topico.repositorio.TopicoRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private PerfilRepositorio perfilRepositorio;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UsuarioRepository autorRepository;

    @Autowired
    private RespostaRepository respostaRepository;

    @Transactional
    public void save(DetalhamentoTopico dados) {

        Topico topico = new Topico(dados);
        Perfil perfil = new Perfil(dados);

        topicoRepository.save(topico);

        entityManager.merge(dados.curso());
        cursoRepository.save(dados.curso());

        entityManager.merge(dados.autor());
        autorRepository.save(dados.autor());

        entityManager.merge(perfil);
        perfilRepositorio.save(perfil);

    }

}
