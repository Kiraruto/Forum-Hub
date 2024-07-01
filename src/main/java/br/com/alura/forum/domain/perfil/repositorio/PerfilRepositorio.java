package br.com.alura.forum.domain.perfil.repositorio;

import br.com.alura.forum.domain.perfil.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepositorio extends JpaRepository<Perfil, Long> {
}
