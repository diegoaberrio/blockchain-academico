package com.certificadosglobales.blockchain_credenciales.services;

import com.certificadosglobales.blockchain_credenciales.model.Usuario;
import com.certificadosglobales.blockchain_credenciales.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Método para registrar un nuevo usuario
    public Usuario register(Usuario usuario) {
        // Cifrar la contraseña antes de guardar el usuario
        usuario.setContraseña(passwordEncoder.encode(usuario.getContraseña()));
        return usuarioRepository.save(usuario);
    }
}
