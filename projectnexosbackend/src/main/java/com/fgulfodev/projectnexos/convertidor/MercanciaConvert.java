package com.fgulfodev.projectnexos.convertidor;

public class MercanciaConvert {

    private String nombre;
    private String cantidad;
    private String fecha_ingreso;
    private String usuarioCreacion;
    private String usuarioModificacion;
    private String fechaModificacion;
    private String estado;


    public MercanciaConvert() {
    }

    public MercanciaConvert(String nombre, String cantidad, String fecha_ingreso, String usuarioCreacion, String usuarioModificacion, String fechaModificacion, String estado) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.fecha_ingreso = fecha_ingreso;
        this.usuarioCreacion = usuarioCreacion;
        this.usuarioModificacion = usuarioModificacion;
        this.fechaModificacion = fechaModificacion;
        this.estado = estado;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha_ingreso() {
        return this.fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getUsuarioCreacion() {
        return this.usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public String getUsuarioModificacion() {
        return this.usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public String getFechaModificacion() {
        return this.fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}
