package com.certificadosglobales.blockchain_credenciales.controller;

import com.certificadosglobales.blockchain_credenciales.model.Credencial;
import com.certificadosglobales.blockchain_credenciales.repository.CredencialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credenciales")
public class CredencialController {

    @Autowired
    private CredencialRepository credencialRepository;

    // Permitir a cualquier usuario autenticado ver todas las credenciales
    @GetMapping
    public List<Credencial> getAllCredenciales() {
        return credencialRepository.findAll();
    }

    // Permitir a cualquier usuario autenticado ver una credencial por ID
    @GetMapping("/{id}")
    public ResponseEntity<Credencial> getCredencialById(@PathVariable String id) {
        return credencialRepository.findById(id)
                .map(credencial -> ResponseEntity.ok().body(credencial))
                .orElse(ResponseEntity.notFound().build());
    }

    // Permitir a cualquier usuario autenticado crear una nueva credencial
    @PostMapping
    public Credencial createCredencial(@RequestBody Credencial credencial) {
        return credencialRepository.save(credencial);
    }

    // Permitir a cualquier usuario autenticado actualizar una credencial existente
    @PutMapping("/{id}")
    public ResponseEntity<Credencial> updateCredencial(
            @PathVariable String id, @RequestBody Credencial credencialDetails) {
        return credencialRepository.findById(id)
                .map(credencial -> {
                    credencial.setTipoCredencial(credencialDetails.getTipoCredencial());
                    credencial.setFechaEmision(credencialDetails.getFechaEmision());
                    credencial.setEstado(credencialDetails.getEstado());
                    credencial.setIdBlockchain(credencialDetails.getIdBlockchain());
                    Credencial updatedCredencial = credencialRepository.save(credencial);
                    return ResponseEntity.ok(updatedCredencial);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Permitir a cualquier usuario autenticado eliminar una credencial
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCredencial(@PathVariable String id) {
        return credencialRepository.findById(id)
                .map(credencial -> {
                    credencialRepository.delete(credencial);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
