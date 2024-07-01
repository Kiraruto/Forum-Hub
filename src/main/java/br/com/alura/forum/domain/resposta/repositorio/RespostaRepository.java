package br.com.alura.forum.domain.resposta.repositorio;

import br.com.alura.forum.domain.resposta.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespostaRepository extends JpaRepository<Resposta, Long> {
}
