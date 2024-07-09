package br.com.alura.forum.domain.resposta.dto;

import br.com.alura.forum.domain.usuario.Usuario;
import br.com.alura.forum.domain.resposta.Resposta;
import br.com.alura.forum.domain.topico.Topico;
import jakarta.validation.constraints.NotNull;

public record DetalhamentoResposta(@NotNull
                                   Long id,
                                   @NotNull
                                   String mensagem,
                                   @NotNull
                                   Topico topico,
                                   @NotNull
                                   Usuario autor,
                                   @NotNull
                                   Boolean solucao
) {
    public DetalhamentoResposta(Resposta dados) {
        this(dados.getId(), dados.getMensagem(), dados.getTopico(), dados.getAutor(), dados.getSolucao());
    }
}

