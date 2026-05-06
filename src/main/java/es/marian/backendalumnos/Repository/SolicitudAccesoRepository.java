package es.marian.backendalumnos.Repository;

import es.marian.backendalumnos.Model.SolicitudAcceso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolicitudAccesoRepository extends JpaRepository<SolicitudAcceso, Long> {

        List<SolicitudAcceso> findByEstado(String estado);

        List<SolicitudAcceso> findByCursoContainingIgnoreCase(String curso);
    }