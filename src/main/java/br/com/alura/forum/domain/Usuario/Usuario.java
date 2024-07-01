package br.com.alura.forum.domain.Usuario;

import br.com.alura.forum.domain.perfil.Perfil;
import br.com.alura.forum.domain.topico.dto.DetalhamentoTopicoId;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "usuario")
@Entity(name = "usuario")
@NoArgsConstructor
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
    @Id
    private Long id;
    private String nome;
    private String email;
    private Integer senha;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Setter
    private Perfil perfil;

    public void atulizarInformacoes(DetalhamentoTopicoId dados) {
        if (dados.autor().getNome() != null) {
            this.nome = dados.autor().getNome();
        }

        if (dados.autor().getEmail() != null) {
            this.email = dados.autor().getEmail() ;
        }

        if (dados.autor().getSenha() != null) {
            this.senha = dados.autor().getSenha();
        }

        if (dados.autor().getPerfil() != null) {
            this.perfil.atualizarInformacoes(dados);
        }
    }
}
