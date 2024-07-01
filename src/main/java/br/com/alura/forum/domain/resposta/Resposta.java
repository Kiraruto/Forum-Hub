package br.com.alura.forum.domain.resposta;

import br.com.alura.forum.domain.Usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "resposta")
@Entity(name = "resposta")
@NoArgsConstructor
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensagem;
    private String topico;
    private LocalDateTime dataCriacao;
    private String autor;
    @ManyToOne
    private Usuario solucao;
}
