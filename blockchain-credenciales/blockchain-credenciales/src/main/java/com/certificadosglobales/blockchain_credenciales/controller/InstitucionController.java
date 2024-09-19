package com.certificadosglobales.blockchain_credenciales.controller;

import com.certificadosglobales.blockchain_credenciales.model.Institucion;
import com.certificadosglobales.blockchain_credenciales.repository.InstitucionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/instituciones")
public class InstitucionController {

    @Autowired
    private InstitucionRepository institucionRepository;

    // Permitir a cualquier usuario autenticado obtener todas las instituciones
    @GetMapping
    public List<Institucion> getAllInstituciones() {
        return institucionRepository.findAll();
    }

    // Permitir a cualquier usuario autenticado obtener una institucion por ID
    @GetMapping("/{id}")
    public ResponseEntity<Institucion> getInstitucionById(@PathVariable String id) {
        Optional<Institucion> institucion = institucionRepository.findById(id);
        return institucion.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Permitir a cualquier usuario autenticado crear una nueva institucion
    @PostMapping
    public Institucion createInstitucion(@RequestBody Institucion institucion) {
        return institucionRepository.save(institucion);
    }

    // Permitir a cualquier usuario autenticado actualizar una institucion existente
    @PutMapping("/{id}")
    public ResponseEntity<Institucion> updateInstitucion(@PathVariable String id, @RequestBody Institucion institucionDetails) {
        return institucionRepository.findById(id)
                .map(institucion -> {
                    institucion.setNombre(institucionDetails.getNombre());
                    institucion.setDireccion(institucionDetails.getDireccion());
                    institucion.setEmail(institucionDetails.getEmail());
                    institucion.setTelefono(institucionDetails.getTelefono());
                    institucion.setPersonaContacto(institucionDetails.getPersonaContacto());
                    Institucion updatedInstitucion = institucionRepository.save(institucion);
                    return ResponseEntity.ok(updatedInstitucion);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Permitir a cualquier usuario autenticado eliminar una institucion
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInstitucion(@PathVariable String id) {
        return institucionRepository.findById(id)
                .map(institucion -> {
                    institucionRepository.delete(institucion);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
