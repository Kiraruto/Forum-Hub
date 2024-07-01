package br.com.alura.forum.domain.topico.repositorio;

import br.com.alura.forum.domain.topico.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Boolean existsByTituloAndMensagem(String titulo, String mensagem);

    Page<Topico> findAllByStatusTrueOrderByDataCriacaoAsc(Pageable pageable);
}
