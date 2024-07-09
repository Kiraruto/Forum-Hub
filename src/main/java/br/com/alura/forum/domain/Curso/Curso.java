package br.com.alura.forum.domain.Curso;

import br.com.alura.forum.domain.topico.dto.DetalhamentoTopicoId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "curso")
@Entity(name = "curso")
@NoArgsConstructor
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {
    @Id
    private Long id;
    private String nome;
    private String categoria;

    public void atualizarInformacoes(DetalhamentoTopicoId dados) {
        if (dados.curso().getNome() != null) {
            this.nome = dados.curso().getNome();
        }

        if (dados.curso().getCategoria() != null) {
            this.categoria = dados.curso().getCategoria();
        }
    }
}
