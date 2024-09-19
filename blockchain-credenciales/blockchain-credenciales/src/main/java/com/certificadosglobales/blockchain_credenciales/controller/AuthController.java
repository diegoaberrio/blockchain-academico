package com.certificadosglobales.blockchain_credenciales.controller;

import com.certificadosglobales.blockchain_credenciales.dto.LoginRequestDTO;
import com.certificadosglobales.blockchain_credenciales.jwt.JWTUtil;
import com.certificadosglobales.blockchain_credenciales.model.Usuario;
import com.certificadosglobales.blockchain_credenciales.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")  // Permitir solicitudes CORS desde el frontend
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AuthService authService;

    // Endpoint para iniciar sesión
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequestDTO loginRequest) {
        // Autenticar al usuario
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getContraseña())
        );
        
        // Establecer contexto de seguridad
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Generar token JWT
        String jwt = jwtUtil.generateToken((UserDetails) authentication.getPrincipal());

        // Respuesta detallada con token y detalles del usuario
        Map<String, Object> response = new HashMap<>();
        response.put("token", jwt);
        response.put("email", loginRequest.getEmail());
        response.put("rol", ((UserDetails) authentication.getPrincipal()).getAuthorities());

        return ResponseEntity.ok(response);
    }

    // Endpoint para registrar usuarios
    @PostMapping("/register")
    public ResponseEntity<Usuario> register(@Valid @RequestBody Usuario usuario) {
        Usuario newUsuario = authService.register(usuario);
        return ResponseEntity.ok(newUsuario);
    }
}
