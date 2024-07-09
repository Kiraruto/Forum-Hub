package br.com.alura.forum.domain.resposta;

import br.com.alura.forum.domain.usuario.Usuario;
import br.com.alura.forum.domain.resposta.dto.DetalhamentoResposta;
import br.com.alura.forum.domain.topico.Topico;
import br.com.alura.forum.domain.topico.dto.DadosTopicoId;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "resposta")
@Entity(name = "resposta")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Resposta {
    @Id
    private Long id;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private Boolean solucao;

    @ManyToOne
    @JoinColumn(name = "topico_id")
    private Topico topico;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    public Resposta(DetalhamentoResposta dados) {
        this.id = dados.id();
        this.mensagem = dados.mensagem();
        this.topico = dados.topico();
        this.dataCriacao = LocalDateTime.now();
        this.autor = dados.autor();
        this.solucao = dados.solucao();
    }

    public Resposta(DadosTopicoId topico) {
        this.id = topico.id();
    }


    public Resposta(String s) {
        this.mensagem = s;
    }


    public Resposta(String mensagem, Usuario autor, Boolean solucao) {
    }
}
