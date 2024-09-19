package com.certificadosglobales.blockchain_credenciales.repository;

import com.certificadosglobales.blockchain_credenciales.model.Verificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificacionRepository extends JpaRepository<Verificacion, String> {
}
