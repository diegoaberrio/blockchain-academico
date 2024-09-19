package com.certificadosglobales.blockchain_credenciales.controller;

import com.certificadosglobales.blockchain_credenciales.model.Blockchain;
import com.certificadosglobales.blockchain_credenciales.repository.BlockchainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blockchain")
public class BlockchainController {

    @Autowired
    private BlockchainRepository blockchainRepository;

    // Permitir a cualquier usuario autenticado ver la lista completa de blockchain
    @GetMapping
    public List<Blockchain> getAllBlockchain() {
        return blockchainRepository.findAll();
    }

    // Permitir a cualquier usuario autenticado ver detalles de una blockchain por ID
    @GetMapping("/{id}")
    public ResponseEntity<Blockchain> getBlockchainById(@PathVariable String id) {
        return blockchainRepository.findById(id)
                .map(blockchain -> ResponseEntity.ok().body(blockchain))
                .orElse(ResponseEntity.notFound().build());
    }

    // Permitir a cualquier usuario autenticado crear una nueva blockchain
    @PostMapping
    public Blockchain createBlockchain(@RequestBody Blockchain blockchain) {
        return blockchainRepository.save(blockchain);
    }

    // Permitir a cualquier usuario autenticado actualizar una blockchain
    @PutMapping("/{id}")
    public ResponseEntity<Blockchain> updateBlockchain(@PathVariable String id, @RequestBody Blockchain blockchainDetails) {
        return blockchainRepository.findById(id)
                .map(blockchain -> {
                    blockchain.setProveedor(blockchainDetails.getProveedor());
                    blockchain.setHashCredencial(blockchainDetails.getHashCredencial());
                    blockchain.setFechaAlmacenamiento(blockchainDetails.getFechaAlmacenamiento());
                    Blockchain updatedBlockchain = blockchainRepository.save(blockchain);
                    return ResponseEntity.ok(updatedBlockchain);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Permitir a cualquier usuario autenticado eliminar una blockchain
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBlockchain(@PathVariable String id) {
        return blockchainRepository.findById(id)
                .map(blockchain -> {
                    blockchainRepository.delete(blockchain);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
