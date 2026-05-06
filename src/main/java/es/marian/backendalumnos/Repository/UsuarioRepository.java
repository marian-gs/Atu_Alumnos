package es.marian.backendalumnos.Repository;

import java.util.Optional;
import es.marian.backendalumnos.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsuarioAndPassword(
            String usuario,
            String password
    );
}