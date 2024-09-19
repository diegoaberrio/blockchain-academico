package com.certificadosglobales.blockchain_credenciales.services;

import com.certificadosglobales.blockchain_credenciales.model.Usuario;
import com.certificadosglobales.blockchain_credenciales.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Buscar usuario por email
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con email: " + email));
        
        // Agregar logging para depuración
        System.out.println("Usuario encontrado: " + usuario.getEmail() + " con rol: " + usuario.getRol().name());
        
        // Devolver el usuario como una implementación de UserDetails
        return new UsuarioPrincipal(usuario);  // Usamos UsuarioPrincipal para encapsular los detalles del usuario
    }
}
