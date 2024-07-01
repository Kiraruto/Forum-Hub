package br.com.alura.forum.domain.topico.dto;

import br.com.alura.forum.domain.Curso.Curso;
import br.com.alura.forum.domain.Usuario.Usuario;

public record DetalhamentoTopicoId(Long id,
                                   String titulo,
                                   String mensagem,
                                   Usuario autor,
                                   Curso curso) {
}
