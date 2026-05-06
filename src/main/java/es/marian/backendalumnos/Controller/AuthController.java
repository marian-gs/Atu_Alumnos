package es.marian.backendalumnos.Controller;

import java.util.Map;
import es.marian.backendalumnos.Model.Usuario;
import es.marian.backendalumnos.Repository.UsuarioRepository;
import es.marian.backendalumnos.dto.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public Map<String, Object> login(
            @RequestBody LoginRequest request
    ) {

        Usuario usuario = usuarioRepository
                .findByUsuarioAndPassword(
                        request.getUsuario(),
                        request.getPassword()
                )
                .orElse(null);

        if (usuario == null) {

            return Map.of(
                    "success", false,
                    "message", "Credenciales incorrectas"
            );
        }

        return Map.of(
                "success", true,
                "rol", usuario.getRol(),
                "usuario", usuario.getUsuario()
        );
    }
}