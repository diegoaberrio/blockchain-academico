package com.certificadosglobales.blockchain_credenciales.repository;

import com.certificadosglobales.blockchain_credenciales.model.EnlaceTemporal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnlaceTemporalRepository extends JpaRepository<EnlaceTemporal, String> {
}
