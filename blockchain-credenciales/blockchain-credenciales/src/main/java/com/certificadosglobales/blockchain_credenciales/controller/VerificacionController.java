package com.certificadosglobales.blockchain_credenciales.controller;

import com.certificadosglobales.blockchain_credenciales.model.Verificacion;
import com.certificadosglobales.blockchain_credenciales.repository.VerificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/verificaciones")
public class VerificacionController {

    @Autowired
    private VerificacionRepository verificacionRepository;

    // Permitir a cualquier usuario autenticado obtener todas las verificaciones
    @GetMapping
    public List<Verificacion> getAllVerificaciones() {
        return verificacionRepository.findAll();
    }

    // Permitir a cualquier usuario autenticado obtener una verificación por ID
    @GetMapping("/{id}")
    public ResponseEntity<Verificacion> getVerificacionById(@PathVariable String id) {
        Optional<Verificacion> verificacion = verificacionRepository.findById(id);
        return verificacion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Permitir a cualquier usuario autenticado crear una nueva verificación
    @PostMapping
    public Verificacion createVerificacion(@RequestBody Verificacion verificacion) {
        return verificacionRepository.save(verificacion);
    }

    // Permitir a cualquier usuario autenticado actualizar una verificación existente
    @PutMapping("/{id}")
    public ResponseEntity<Verificacion> updateVerificacion(@PathVariable String id, @RequestBody Verificacion verificacionDetails) {
        Optional<Verificacion> verificacionOpt = verificacionRepository.findById(id);
        return verificacionOpt.map(verificacion -> {
            verificacion.setCredencial(verificacionDetails.getCredencial());
            verificacion.setEmpleador(verificacionDetails.getEmpleador());
            verificacion.setFechaVerificacion(verificacionDetails.getFechaVerificacion());
            verificacion.setEstado(verificacionDetails.getEstado());
            Verificacion updatedVerificacion = verificacionRepository.save(verificacion);
            return ResponseEntity.ok(updatedVerificacion);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Permitir a cualquier usuario autenticado eliminar una verificación
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVerificacion(@PathVariable String id) {
        Optional<Verificacion> verificacion = verificacionRepository.findById(id);
        return verificacion.map(v -> {
            verificacionRepository.delete(v);
            return ResponseEntity.ok().build();
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
