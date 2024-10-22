package br.com.alura.forum.domain.topico.dto;

import br.com.alura.forum.domain.Curso.Curso;
import br.com.alura.forum.domain.Usuario.Usuario;
import br.com.alura.forum.domain.topico.Topico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DetalhamentoTopico(@NotBlank
                                 String titulo,
                                 @NotBlank
                                 String mensagem,
                                 @NotNull
                                 Usuario autor,
                                 @NotNull
                                 Curso curso) {
    public DetalhamentoTopico(Topico dados) {
        this(dados.getTitulo(), dados.getMensagem(), dados.getAutor(), dados.getCurso());
    }
}
