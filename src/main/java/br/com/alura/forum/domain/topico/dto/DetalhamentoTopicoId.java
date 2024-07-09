package br.com.alura.forum.domain.topico.dto;

import br.com.alura.forum.domain.Curso.Curso;
import br.com.alura.forum.domain.usuario.Usuario;
import br.com.alura.forum.domain.resposta.dto.DetalhamentoResposta;

public record DetalhamentoTopicoId(Long id,
                                   String titulo,
                                   String mensagem,
                                   Usuario autor,
                                   Curso curso
) {
    public DetalhamentoTopicoId(DetalhamentoResposta dados) {
        this(dados.id(), null, null, null, null);
    }
}
