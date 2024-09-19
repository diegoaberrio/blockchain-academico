package com.certificadosglobales.blockchain_credenciales.repository;

import com.certificadosglobales.blockchain_credenciales.model.Blockchain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockchainRepository extends JpaRepository<Blockchain, String> {
    // Puedes agregar métodos personalizados aquí si es necesario
}
