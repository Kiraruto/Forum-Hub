package br.com.alura.forum.domain.topico.dto;

import br.com.alura.forum.domain.Curso.Curso;
import br.com.alura.forum.domain.Usuario.Usuario;
import br.com.alura.forum.domain.topico.Topico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DetalhamentoTopicoToStatusEDataCriacao(@NotBlank
                                                     String titulo,
                                                     @NotBlank
                                                     String mensagem,
                                                     @NotNull
                                                     LocalDateTime dataCriacao,
                                                     @NotNull
                                                     Boolean status,
                                                     @NotNull
                                                     Usuario autor,
                                                     @NotNull
                                                     Curso curso) {

    public DetalhamentoTopicoToStatusEDataCriacao(Topico dados) {
        this(dados.getTitulo(), dados.getMensagem(), dados.getDataCriacao(), dados.getStatus(), dados.getAutor(), dados.getCurso());
    }
}
