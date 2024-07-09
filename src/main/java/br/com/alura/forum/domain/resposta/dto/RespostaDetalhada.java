package br.com.alura.forum.domain.resposta.dto;

import br.com.alura.forum.domain.usuario.Usuario;

public record RespostaDetalhada(String mensagem, Boolean solucao, Usuario autor) {
}
