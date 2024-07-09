package br.com.alura.forum.domain.resposta.service;

import br.com.alura.forum.domain.resposta.Resposta;
import br.com.alura.forum.domain.resposta.dto.DetalhamentoResposta;
import br.com.alura.forum.domain.resposta.repositorio.RespostaRepository;
import br.com.alura.forum.domain.topico.Topico;
import br.com.alura.forum.domain.topico.repositorio.TopicoRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RespostaService {

    @Autowired
    EntityManager entityManager;
    @Autowired
    private RespostaRepository respostaRepository;
    @Autowired
    private TopicoRepository topicoRepository;

    @Transactional
    public void saveResposta(@Valid DetalhamentoResposta dados) {

        Resposta resposta = new Resposta(dados);

        respostaRepository.save(resposta);

        List<Resposta> respostaList = new ArrayList<>();
        respostaList.add(resposta);

        atualizarTopicoColunaResposta_id(respostaList);

    }

    @Transactional
    private void atualizarTopicoColunaResposta_id(List<Resposta> novasRespostas) {
        List<Topico> topicosComRespostasNulas = topicoRepository.findByRespostaIsNull();

        for (Topico topico : topicosComRespostasNulas) {
            topico.setResposta(novasRespostas);
            topicoRepository.save(topico);
        }
    }
}
