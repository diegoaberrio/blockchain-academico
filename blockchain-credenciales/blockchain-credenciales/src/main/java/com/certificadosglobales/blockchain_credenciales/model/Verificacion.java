package com.certificadosglobales.blockchain_credenciales.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "verificaciones")
public class Verificacion {

    @Id
    @Column(name = "ID_Verificacion", nullable = false)
    @Size(min = 36, max = 36, message = "El ID de Verificación debe tener 36 caracteres")
    private String idVerificacion;

    @ManyToOne
    @JoinColumn(name = "ID_Credencial", nullable = false)
    @NotNull(message = "La credencial es obligatoria")
    private Credencial credencial;

    @ManyToOne
    @JoinColumn(name = "ID_Empleador", nullable = false)
    @NotNull(message = "El empleador es obligatorio")
    private Usuario empleador;

    @Column(name = "Fecha_Verificacion", nullable = false)
    @NotNull(message = "La fecha de verificación es obligatoria")
    @PastOrPresent(message = "La fecha de verificación no puede estar en el futuro")
    private LocalDateTime fechaVerificacion;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "El estado es obligatorio")
    @Column(name = "Estado", nullable = false)
    private Estado estado;

    // Enum Estado
    public enum Estado {
        Pendiente, Verificado
    }

    // Getters y Setters
    public String getIdVerificacion() {
        return idVerificacion;
    }

    public void setIdVerificacion(String idVerificacion) {
        this.idVerificacion = idVerificacion;
    }

    public Credencial getCredencial() {
        return credencial;
    }

    public void setCredencial(Credencial credencial) {
        this.credencial = credencial;
    }

    public Usuario getEmpleador() {
        return empleador;
    }

    public void setEmpleador(Usuario empleador) {
        this.empleador = empleador;
    }

    public LocalDateTime getFechaVerificacion() {
        return fechaVerificacion;
    }

    public void setFechaVerificacion(LocalDateTime fechaVerificacion) {
        this.fechaVerificacion = fechaVerificacion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
