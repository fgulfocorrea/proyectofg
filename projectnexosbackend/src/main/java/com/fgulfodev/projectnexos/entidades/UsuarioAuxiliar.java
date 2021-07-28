package com.fgulfodev.projectnexos.entidades;

public class UsuarioAuxiliar extends Usuario{
    private String nombreRole;
    private String nombrePersona;
    private Integer edad;


    public UsuarioAuxiliar() {
    }

    public UsuarioAuxiliar(String nombreRole, String nombrePersona, Integer edad) {
        this.nombreRole = nombreRole;
        this.nombrePersona = nombrePersona;
        this.edad = edad;
    }

    public String getNombreRole() {
        return this.nombreRole;
    }

    public void setNombreRole(String nombreRole) {
        this.nombreRole = nombreRole;
    }

    public String getNombrePersona() {
        return this.nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public Integer getEdad() {
        return this.edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    

}
