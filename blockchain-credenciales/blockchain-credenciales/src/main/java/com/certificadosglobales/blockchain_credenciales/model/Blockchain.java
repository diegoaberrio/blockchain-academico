package com.certificadosglobales.blockchain_credenciales.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "blockchain")
public class Blockchain {

    @Id
    @Column(name = "ID_Blockchain", nullable = false)
    @NotBlank(message = "El ID de Blockchain es obligatorio")
    @Size(min = 36, max = 36, message = "El ID de Blockchain debe tener exactamente 36 caracteres")
    private String idBlockchain;

    @Enumerated(EnumType.STRING)
    @Column(name = "Proveedor", nullable = false)
    @NotNull(message = "El proveedor es obligatorio")
    private Proveedor proveedor;

    @Column(name = "Hash_Credencial", nullable = false)
    @NotBlank(message = "El hash de la credencial es obligatorio")
    @Size(min = 64, max = 64, message = "El hash de la credencial debe tener 64 caracteres")  // Suponiendo que el hash sea de 64 caracteres
    private String hashCredencial;

    @Column(name = "Fecha_Almacenamiento", nullable = false)
    @NotNull(message = "La fecha de almacenamiento es obligatoria")
    private LocalDateTime fechaAlmacenamiento;

    public String getIdBlockchain() {
        return idBlockchain;
    }

    public void setIdBlockchain(String idBlockchain) {
        this.idBlockchain = idBlockchain;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public String getHashCredencial() {
        return hashCredencial;
    }

    public void setHashCredencial(String hashCredencial) {
        this.hashCredencial = hashCredencial;
    }

    public LocalDateTime getFechaAlmacenamiento() {
        return fechaAlmacenamiento;
    }

    public void setFechaAlmacenamiento(LocalDateTime fechaAlmacenamiento) {
        this.fechaAlmacenamiento = fechaAlmacenamiento;
    }

    public enum Proveedor {
        Ethereum, Hyperledger
    }
}
