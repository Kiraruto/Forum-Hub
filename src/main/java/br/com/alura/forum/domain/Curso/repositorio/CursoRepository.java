package br.com.alura.forum.domain.Curso.repositorio;

import br.com.alura.forum.domain.Curso.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
