package br.com.alura.forum.domain.resposta.repositorio;

import br.com.alura.forum.domain.resposta.Resposta;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RespostaRepository extends JpaRepository<Resposta, Long> {
    Boolean existsByMensagem(String mensagem);

    List<Resposta> findByTopicoId(@Param("topicoId") Long topicoId);

    @Transactional
    @Modifying
    @Query("DELETE FROM resposta r WHERE r.topico.id = :topicoId")
    void deleteByTopico_Id(@Param("topicoId") Long topicoId);}
