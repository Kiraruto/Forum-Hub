package br.com.alura.forum.domain.topico.dto;

import br.com.alura.forum.domain.resposta.Resposta;

public record DadosTopicoId(Long id) {
    public DadosTopicoId(Resposta resposta) {
        this(resposta.getId());
    }
}
