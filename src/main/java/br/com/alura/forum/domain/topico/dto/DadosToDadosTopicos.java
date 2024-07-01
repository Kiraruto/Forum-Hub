package br.com.alura.forum.domain.topico.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosToDadosTopicos(@NotNull
                                  String titulo,
                                  @NotNull
                                  String mensagem,
                                  @NotBlank
                                  String autor,
                                  @NotBlank
                                  String curso) {
}
