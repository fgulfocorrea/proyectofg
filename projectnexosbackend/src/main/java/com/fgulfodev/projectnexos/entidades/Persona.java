package com.fgulfodev.projectnexos.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "personas")
public class Persona {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 15)
    private String identificacion;

    @Column(nullable = false, length = 200)
    private String nombres;

    @Column(nullable = false, length = 200)
    private String apellidos;

    @Column(nullable = false, length = 3)
    private Integer edad;

    @Column(nullable = false, length = 10)
    private String telefono;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false)
    private Boolean estado;

    public Persona() {
    }

    public Persona(Long id, String identificacion, String nombres, String apellidos, Integer edad, String telefono, String email, Boolean estado) {
        this.id = id;
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.telefono = telefono;
        this.email = email;
        this.estado = estado;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentificacion() {
        return this.identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return this.nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getEdad() {
        return this.edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean isEstado() {
        return this.estado;
    }

    public Boolean getEstado() {
        return this.estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

}
