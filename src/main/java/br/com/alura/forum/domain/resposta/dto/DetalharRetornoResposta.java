package br.com.alura.forum.domain.resposta.dto;

import br.com.alura.forum.domain.resposta.Resposta;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DetalharRetornoResposta {
    private final List<RespostaDetalhada> Respostas;

    public DetalharRetornoResposta(List<Resposta> respostas) {
        this.Respostas = new ArrayList<>();
        for (Resposta resposta : respostas) {
            RespostaDetalhada detalhe = new RespostaDetalhada(
                    resposta.getMensagem(),
                    resposta.getSolucao(),
                    resposta.getAutor()
            );
            this.Respostas.add(detalhe);
        }
    }
}
