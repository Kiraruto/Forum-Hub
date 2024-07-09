package br.com.alura.forum.domain.topico.dto;

import br.com.alura.forum.domain.Curso.Curso;
import br.com.alura.forum.domain.usuario.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DetalhamentoTopico(@NotBlank
                                 String titulo,
                                 @NotBlank
                                 String mensagem,
                                 @NotNull
                                 Usuario autor,
                                 @NotNull
                                 Curso curso
) {
}
