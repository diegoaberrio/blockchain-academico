package com.certificadosglobales.blockchain_credenciales.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "credenciales")
public class Credencial {

    @Id
    @Column(name = "ID_Credencial", nullable = false)
    @Size(min = 36, max = 36, message = "El ID de Credencial debe tener 36 caracteres")
    private String idCredencial;

    @ManyToOne
    @JoinColumn(name = "ID_Usuario")
    private Usuario usuario;  // No se requiere @NotNull si se permite nulo.

    @ManyToOne
    @JoinColumn(name = "ID_Institucion")
    private Institucion institucion;  // Similar al usuario.

    @Enumerated(EnumType.STRING)
    @NotNull(message = "El tipo de credencial es obligatorio")
    @Column(name = "Tipo_Credencial", nullable = false)
    private TipoCredencial tipoCredencial;

    @Column(name = "Fecha_Emision")
    @PastOrPresent(message = "La fecha de emisión no puede estar en el futuro")
    private Date fechaEmision;

    @Size(min = 36, max = 36, message = "El ID de Blockchain debe tener 36 caracteres")
    @Column(name = "id_blockchain")
    private String idBlockchain;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "El estado es obligatorio")
    @Column(name = "Estado", nullable = false)
    private Estado estado;

    // Getters y Setters...

    public String getIdCredencial() {
        return idCredencial;
    }

    public void setIdCredencial(String idCredencial) {
        this.idCredencial = idCredencial;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }

    public TipoCredencial getTipoCredencial() {
        return tipoCredencial;
    }

    public void setTipoCredencial(TipoCredencial tipoCredencial) {
        this.tipoCredencial = tipoCredencial;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getIdBlockchain() {
        return idBlockchain;
    }

    public void setIdBlockchain(String idBlockchain) {
        this.idBlockchain = idBlockchain;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public enum TipoCredencial {
        Certificado, Diploma
    }

    public enum Estado {
        Emitido, Verificado
    }
}
