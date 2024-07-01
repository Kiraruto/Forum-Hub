package br.com.alura.forum.domain.topico;

import br.com.alura.forum.domain.Curso.Curso;
import br.com.alura.forum.domain.resposta.Resposta;
import br.com.alura.forum.domain.Usuario.Usuario;
import br.com.alura.forum.domain.topico.dto.DetalhamentoTopico;
import br.com.alura.forum.domain.topico.dto.DetalhamentoTopicoId;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "topico")
@Entity(name = "topico")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private Boolean status;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Usuario autor;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Curso curso;
    @OneToMany
    private List<Resposta> resposta;

    public Topico(DetalhamentoTopico dados) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.dataCriacao = LocalDateTime.now();
        this.status = true;
        this.autor = dados.autor();
        this.curso = dados.curso();
    }

    public void statusFalse() {
        this.status = false;
    }

    public void atualizarInformacoes(@Valid DetalhamentoTopicoId dados) {
        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }

        if (dados.mensagem() != null) {
            this.mensagem = dados.mensagem();
        }

        if (dados.autor() != null) {
            this.autor.atulizarInformacoes(dados);
        }

        if (dados.curso() != null) {
            this.curso.atualizarInformacoes(dados);
        }
    }
}

