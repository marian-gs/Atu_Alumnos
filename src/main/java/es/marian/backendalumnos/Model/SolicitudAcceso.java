package es.marian.backendalumnos.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "solicitud_acceso")
public class SolicitudAcceso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    private String dni;

    private String curso;

    private String telefono;

    private String email;

    private String estado;

    @Column(columnDefinition = "TEXT")
    private String notas;

    private LocalDateTime fechaCreacion;

}
