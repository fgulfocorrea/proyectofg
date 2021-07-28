package com.fgulfodev.projectnexos.iservicio;

import java.util.List;

import com.fgulfodev.projectnexos.entidades.Persona;

public interface IPersonaServicio {
    
    public Persona crear(Persona persona);
    public Persona actualizar(Persona persona);
    public void eliminar(String id);
    public Persona obtenerPorId(String id);
    public List<Persona> obtenerTodo();
    public Persona obtenerPorIdentificacion(String identificacion);
    public Persona obtenerPorEmail(String email);
    public Persona obtenerPorEdad(Integer edad);
}
