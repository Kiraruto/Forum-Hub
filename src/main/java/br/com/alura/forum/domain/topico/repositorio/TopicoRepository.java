package br.com.alura.forum.domain.topico.repositorio;

import br.com.alura.forum.domain.resposta.Resposta;
import br.com.alura.forum.domain.topico.Topico;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Boolean existsByTituloAndMensagem(String titulo, String mensagem);

    Page<Topico> findAllByStatusTrueOrderByDataCriacaoAsc(Pageable pageable);

    @Modifying
    @Transactional
    @Query("UPDATE topico t SET t.resposta = :resposta WHERE t.resposta IS NULL")
    void updateNullRespostas(@Param("resposta") List<Resposta> resposta);

    List<Topico> findByRespostaIsNull();
}
