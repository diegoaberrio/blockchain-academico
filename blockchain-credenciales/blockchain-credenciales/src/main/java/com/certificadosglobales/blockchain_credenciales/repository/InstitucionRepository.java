package com.certificadosglobales.blockchain_credenciales.repository;

import com.certificadosglobales.blockchain_credenciales.model.Institucion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstitucionRepository extends JpaRepository<Institucion, String> {
}
