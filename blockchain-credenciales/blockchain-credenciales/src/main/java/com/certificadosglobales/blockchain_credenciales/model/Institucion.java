package com.certificadosglobales.blockchain_credenciales.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "instituciones")  // Nombre de la tabla en minúsculas según la estructura SQL
public class Institucion {

    @Id
    @Column(name = "ID_Institucion", nullable = false)
    @Size(min = 36, max = 36, message = "El ID de la Institución debe tener 36 caracteres")
    private String idInstitucion;

    @Column(name = "Nombre", nullable = false)
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 255, message = "El nombre debe tener entre 2 y 255 caracteres")
    private String nombre;

    @Column(name = "Direccion")
    @Size(max = 255, message = "La dirección no debe exceder los 255 caracteres")
    private String direccion;

    @Column(name = "Email", nullable = false)
    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El formato del email es inválido")
    private String email;

    @Column(name = "telefono")
    @Size(max = 15, message = "El teléfono no debe exceder los 15 caracteres")
    private String telefono;

    @Column(name = "Persona_Contacto")
    @Size(max = 255, message = "El nombre de la persona de contacto no debe exceder los 255 caracteres")
    private String personaContacto;

    // Getters y Setters
    public String getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(String idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPersonaContacto() {
        return personaContacto;
    }

    public void setPersonaContacto(String personaContacto) {
        this.personaContacto = personaContacto;
    }
}
