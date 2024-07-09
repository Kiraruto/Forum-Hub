package br.com.alura.forum.domain.resposta.dto;

public record DadosRespostas(String mensagem) {
    public DadosRespostas(DetalhamentoResposta dados) {
        this(dados.mensagem());
    }
}
