package br.com.alura.forum.domain.perfil;

import br.com.alura.forum.domain.usuario.dto.DetalhamentoUsuario;
import br.com.alura.forum.domain.topico.dto.DetalhamentoTopico;
import br.com.alura.forum.domain.topico.dto.DetalhamentoTopicoId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "perfil")
@Entity(name = "perfil")
@NoArgsConstructor
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Perfil {
    @Id
    private Long id;
    private String nome;

    public Perfil(DetalhamentoTopico dados) {
        this.id = dados.autor().getPerfil().getId();
        this.nome = dados.autor().getPerfil().getNome();
    }

    public Perfil(DetalhamentoUsuario dados) {
        this.id = dados.perfil().getId();
        this.nome =dados.perfil().getNome();
    }

    public void atualizarInformacoes(DetalhamentoTopicoId dados) {
        if (dados.autor().getPerfil() != null) {
            this.nome = dados.autor().getPerfil().getNome();
        }
    }
}


