package es.marian.backendalumnos.Controller;

import es.marian.backendalumnos.Model.SolicitudAcceso;
import es.marian.backendalumnos.Repository.SolicitudAccesoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solicitudes")
@CrossOrigin(origins = "*")
public class SolicitudController {

    private final SolicitudAccesoRepository repository;

    public SolicitudController(SolicitudAccesoRepository repository) {
        this.repository = repository;
    }

    //  Crear solicitud (formulario alumno)
    @PostMapping
    public SolicitudAcceso crear(@RequestBody SolicitudAcceso solicitud) {
        return repository.save(solicitud);
    }

    // Listar solicitudes (con filtros opcionales)
    @GetMapping
    public List<SolicitudAcceso> listar(
            @RequestParam(required = false) String estado,
            @RequestParam(required = false) String curso
    ) {

        if (estado != null) {
            return repository.findByEstado(estado);
        }

        if (curso != null) {
            return repository.findByCursoContainingIgnoreCase(curso);
        }

        return repository.findAll();
    }

    // Ver detalle de una solicitud

    @GetMapping("/{id}")
    public ResponseEntity<SolicitudAcceso> detalle(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //  Cambiar estado
    @PutMapping("/{id}/estado")
    public SolicitudAcceso cambiarEstado(
            @PathVariable Long id,
            @RequestParam String estado
    ) {
        SolicitudAcceso s = repository.findById(id).orElseThrow();
        s.setEstado(estado);
        return repository.save(s);
    }

    //  Guardar notas internas
    @PutMapping("/{id}/notas")
    public SolicitudAcceso actualizarNotas(
            @PathVariable Long id,
            @RequestBody String notas
    ) {
        SolicitudAcceso s = repository.findById(id).orElseThrow();
        s.setNotas(notas);
        return repository.save(s);
    }
}