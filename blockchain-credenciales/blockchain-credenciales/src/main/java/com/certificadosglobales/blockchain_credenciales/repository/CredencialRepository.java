package com.certificadosglobales.blockchain_credenciales.repository;

import com.certificadosglobales.blockchain_credenciales.model.Credencial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredencialRepository extends JpaRepository<Credencial, String> {
}
