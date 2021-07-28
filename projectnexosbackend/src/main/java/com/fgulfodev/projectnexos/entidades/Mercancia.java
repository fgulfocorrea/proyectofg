package com.fgulfodev.projectnexos.entidades;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name="mercancias")
public class Mercancia {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 200)
    private String nombreProducto;

    @Column(nullable = false, length = 100000)
    private Integer cantidad;

    @Column(nullable = false)
    private  Date fechaIngreso;

    @ManyToOne
    private Usuario usuarioCreacion;

    @ManyToOne
    private Usuario usuarioModificacion;

    @Column(nullable = true)
    private  Date fechaModificacion;

    @Column(nullable = false)
    private Boolean estado;

    public Mercancia() {
    }

    public Mercancia(Long id, String nombreProducto, Integer cantidad, Date fechaIngreso, Usuario usuarioCreacion, Usuario usuarioModificacion, Date fechaModificacion) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.fechaIngreso = fechaIngreso;
        this.usuarioCreacion = usuarioCreacion;
        this.usuarioModificacion = usuarioModificacion;
        this.fechaModificacion = fechaModificacion;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return this.nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Integer getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaIngreso() {
        return this.fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Usuario getUsuarioCreacion() {
        return this.usuarioCreacion;
    }

    public void setUsuarioCreacion(Usuario usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public Usuario getUsuarioModificacion() {
        return this.usuarioModificacion;
    }

    public void setUsuarioModificacion(Usuario usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public Date getFechaModificacion() {
        return this.fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
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

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombreProducto='" + getNombreProducto() + "'" +
            ", cantidad='" + getCantidad() + "'" +
            ", fechaIngreso='" + getFechaIngreso() + "'" +
            ", usuarioCreacion='" + getUsuarioCreacion() + "'" +
            ", usuarioModificacion='" + getUsuarioModificacion() + "'" +
            ", fechaModificacion='" + getFechaModificacion() + "'" +
            ", estado='" + isEstado() + "'" +
            "}";
    }

}
