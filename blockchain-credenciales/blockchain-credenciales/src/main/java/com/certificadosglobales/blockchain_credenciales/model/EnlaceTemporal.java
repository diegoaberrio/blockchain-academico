package com.certificadosglobales.blockchain_credenciales.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "enlaces_temporales")
public class EnlaceTemporal {

    @Id
    @Column(name = "ID_Enlace", nullable = false)
    @Size(min = 36, max = 36, message = "El ID de Enlace debe tener 36 caracteres")
    private String idEnlace;

    @ManyToOne
    @JoinColumn(name = "ID_Credencial", nullable = false)
    @NotNull(message = "La credencial es obligatoria")
    private Credencial credencial;

    @Column(name = "Fecha_Creacion", nullable = false)
    @NotNull(message = "La fecha de creación es obligatoria")
    @PastOrPresent(message = "La fecha de creación no puede estar en el futuro")
    private LocalDateTime fechaCreacion;

    @Column(name = "Fecha_Expiracion")
    @FutureOrPresent(message = "La fecha de expiración debe estar en el futuro o en el presente")
    private LocalDateTime fechaExpiracion;

    @Column(name = "URL_Enlace", nullable = false)
    @NotBlank(message = "La URL del enlace es obligatoria")
    @Size(max = 255, message = "La URL del enlace no debe exceder los 255 caracteres")
    private String urlEnlace;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "El estado es obligatorio")
    @Column(name = "Estado", nullable = false)
    private Estado estado;

    // Enum Estado
    public enum Estado {
        Activo, Expirado
    }

    // Getters y Setters
    public String getIdEnlace() {
        return idEnlace;
    }

    public void setIdEnlace(String idEnlace) {
        this.idEnlace = idEnlace;
    }

    public Credencial getCredencial() {
        return credencial;
    }

    public void setCredencial(Credencial credencial) {
        this.credencial = credencial;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(LocalDateTime fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public String getUrlEnlace() {
        return urlEnlace;
    }

    public void setUrlEnlace(String urlEnlace) {
        this.urlEnlace = urlEnlace;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
