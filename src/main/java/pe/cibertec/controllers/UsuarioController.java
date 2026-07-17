package pe.cibertec.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.cibertec.entities.Usuario;
import pe.cibertec.repository.UsuarioRepository;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    //alt mas insert para incializar constructor
    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    //funcion para registrare un nuevo usaaruio
    @PostMapping("/registrar")
    public ResponseEntity<Usuario> registrar(@RequestBody Usuario usuario){
        Usuario usuarioRegistrado = usuarioRepository.save(usuario);
        return ResponseEntity.ok(usuarioRegistrado);
    }

    //funcion para mostrr todos los usuarios registrados
    @GetMapping
    public List<Usuario> listar(){
        return usuarioRepository.findAll();
    }
}

