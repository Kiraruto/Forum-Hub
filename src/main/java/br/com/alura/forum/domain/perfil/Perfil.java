package br.com.alura.forum.domain.perfil;

import br.com.alura.forum.domain.Usuario.Usuario;
import br.com.alura.forum.domain.perfil.dto.DadosPerfil;
import br.com.alura.forum.domain.topico.dto.DetalhamentoTopico;
import br.com.alura.forum.domain.topico.dto.DetalhamentoTopicoId;
import jakarta.persistence.*;
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

    public void atualizarInformacoes(DetalhamentoTopicoId dados) {
        if (dados.autor().getPerfil() != null) {
            this.nome = dados.autor().getPerfil().getNome(); ;
        }
    }
}


