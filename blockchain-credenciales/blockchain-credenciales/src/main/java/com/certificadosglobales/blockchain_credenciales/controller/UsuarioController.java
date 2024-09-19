package com.certificadosglobales.blockchain_credenciales.controller;

import com.certificadosglobales.blockchain_credenciales.model.Usuario;
import com.certificadosglobales.blockchain_credenciales.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Permitir a cualquier usuario autenticado obtener todos los usuarios
    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    // Permitir a cualquier usuario autenticado obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable String id) {
        return usuarioRepository.findById(id)
                .map(usuario -> ResponseEntity.ok().body(usuario))
                .orElse(ResponseEntity.notFound().build());
    }

    // Permitir a cualquier usuario autenticado registrar un nuevo usuario
    @PostMapping("/register")
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        // Generar un UUID para el nuevo usuario
        usuario.setIdUsuario(UUID.randomUUID().toString());

        // Cifrar la contraseña antes de guardarla
        usuario.setContraseña(passwordEncoder.encode(usuario.getContraseña()));

        return usuarioRepository.save(usuario);
    }

    // Permitir a cualquier usuario autenticado actualizar un usuario existente
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable String id, @RequestBody Usuario usuarioDetails) {
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    usuario.setNombre(usuarioDetails.getNombre());
                    usuario.setEmail(usuarioDetails.getEmail());
                    usuario.setRol(usuarioDetails.getRol().toString());

                    // Cifrar la contraseña si se está actualizando
                    usuario.setContraseña(passwordEncoder.encode(usuarioDetails.getContraseña()));

                    Usuario updatedUsuario = usuarioRepository.save(usuario);
                    return ResponseEntity.ok(updatedUsuario);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Permitir a cualquier usuario autenticado eliminar un usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable String id) {
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    usuarioRepository.delete(usuario);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
