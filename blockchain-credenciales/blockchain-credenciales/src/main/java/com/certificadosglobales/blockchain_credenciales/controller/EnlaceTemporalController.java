package com.certificadosglobales.blockchain_credenciales.controller;

import com.certificadosglobales.blockchain_credenciales.model.EnlaceTemporal;
import com.certificadosglobales.blockchain_credenciales.repository.EnlaceTemporalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enlaces-temporales")
public class EnlaceTemporalController {

    @Autowired
    private EnlaceTemporalRepository enlaceTemporalRepository;

    // Permitir a cualquier usuario autenticado obtener todos los enlaces temporales
    @GetMapping
    public List<EnlaceTemporal> getAllEnlacesTemporales() {
        return enlaceTemporalRepository.findAll();
    }

    // Permitir a cualquier usuario autenticado obtener un enlace temporal por ID
    @GetMapping("/{id}")
    public ResponseEntity<EnlaceTemporal> getEnlaceTemporalById(@PathVariable String id) {
        Optional<EnlaceTemporal> enlaceTemporal = enlaceTemporalRepository.findById(id);
        return enlaceTemporal.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Permitir a cualquier usuario autenticado crear un nuevo enlace temporal
    @PostMapping
    public EnlaceTemporal createEnlaceTemporal(@RequestBody EnlaceTemporal enlaceTemporal) {
        return enlaceTemporalRepository.save(enlaceTemporal);
    }

    // Permitir a cualquier usuario autenticado actualizar un enlace temporal existente
    @PutMapping("/{id}")
    public ResponseEntity<EnlaceTemporal> updateEnlaceTemporal(@PathVariable String id, @RequestBody EnlaceTemporal enlaceTemporalDetails) {
        Optional<EnlaceTemporal> enlaceTemporalOpt = enlaceTemporalRepository.findById(id);
        return enlaceTemporalOpt.map(enlaceTemporal -> {
            enlaceTemporal.setCredencial(enlaceTemporalDetails.getCredencial());
            enlaceTemporal.setFechaCreacion(enlaceTemporalDetails.getFechaCreacion());
            enlaceTemporal.setFechaExpiracion(enlaceTemporalDetails.getFechaExpiracion());
            enlaceTemporal.setUrlEnlace(enlaceTemporalDetails.getUrlEnlace());
            enlaceTemporal.setEstado(enlaceTemporalDetails.getEstado());
            EnlaceTemporal updatedEnlaceTemporal = enlaceTemporalRepository.save(enlaceTemporal);
            return ResponseEntity.ok(updatedEnlaceTemporal);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Permitir a cualquier usuario autenticado eliminar un enlace temporal
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEnlaceTemporal(@PathVariable String id) {
        Optional<EnlaceTemporal> enlaceTemporal = enlaceTemporalRepository.findById(id);
        return enlaceTemporal.map(e -> {
            enlaceTemporalRepository.delete(e);
            return ResponseEntity.ok().build();
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
