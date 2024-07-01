package br.com.alura.forum.domain.Usuario.repository;

import br.com.alura.forum.domain.Usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Usuario, Long> {

}
