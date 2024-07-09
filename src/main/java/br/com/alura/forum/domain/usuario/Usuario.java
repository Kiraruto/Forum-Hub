package br.com.alura.forum.domain.usuario;

import br.com.alura.forum.domain.usuario.dto.DetalhamentoUsuario;
import br.com.alura.forum.domain.perfil.Perfil;
import br.com.alura.forum.domain.topico.dto.DetalhamentoTopicoId;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "usuario")
@Entity(name = "usuario")
@NoArgsConstructor
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {
    @Id
    private Long id;
    private String nome;
    private String email;
    private String senha;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Setter
    private Perfil perfil;

    public Usuario(DetalhamentoUsuario dados) {
        this.id = dados.id();
        this.nome = dados.nome();
        this.email = dados.email();
        this.senha = dados.senha();
        this.perfil = dados.perfil();
    }

    public void atulizarInformacoes(DetalhamentoTopicoId dados) {
        if (dados.autor().getNome() != null) {
            this.nome = dados.autor().getNome();
        }

        if (dados.autor().getEmail() != null) {
            this.email = dados.autor().getEmail();
        }

        if (dados.autor().getSenha() != null) {
            this.senha = dados.autor().getSenha();
        }

        if (dados.autor().getPerfil() != null) {
            this.perfil.atualizarInformacoes(dados);
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
