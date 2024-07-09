package br.com.alura.forum.domain.usuario.dto;

import br.com.alura.forum.domain.perfil.Perfil;
import jakarta.validation.constraints.NotNull;

public record DetalhamentoUsuario(@NotNull
                                  Long id,
                                  @NotNull
                                  String nome,
                                  @NotNull
                                  String email,
                                  @NotNull
                                  String senha,
                                  @NotNull
                                  Perfil perfil) {
}
