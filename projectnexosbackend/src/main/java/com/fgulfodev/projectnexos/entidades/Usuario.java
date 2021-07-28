package com.fgulfodev.projectnexos.entidades;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name="usuarios")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false)
    private Date fecha_ingreso;

    @ManyToOne
    private Role role;
    
    @ManyToOne
    private Persona persona;
    
    @Column(nullable = false)
    private Boolean estado;

    public Usuario() {
    }

    public Usuario(Long id, String nombre, Date fecha_ingreso, Role role, Persona persona, Boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.fecha_ingreso = fecha_ingreso;
        this.role = role;
        this.persona = persona;
        this.estado = estado;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_ingreso() {
        return this.fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public Boolean isEstado() {
        return this.estado;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Persona getPersona() {
        return this.persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Boolean getEstado() {
        return this.estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
