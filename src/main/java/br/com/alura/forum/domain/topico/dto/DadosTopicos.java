package br.com.alura.forum.domain.topico.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosTopicos(@NotNull
                           String titulo,
                           @NotNull
                           String mensagem,
                           @NotBlank
                           String autor,
                           @NotBlank
                           String curso) {
    public DadosTopicos(DadosToDadosTopicos dados) {
        this(dados.titulo(), dados.mensagem(), dados.autor(), dados.curso());
    }
}
