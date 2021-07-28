package com.fgulfodev.projectnexos.implementservicio;

import java.util.List;

import com.fgulfodev.projectnexos.entidades.Persona;
import com.fgulfodev.projectnexos.iservicio.IPersonaServicio;
import com.fgulfodev.projectnexos.repositorio.PersonaRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServicio implements IPersonaServicio{


    @Autowired
    private PersonaRepositorio personaRepositorio;

    @Override
    public Persona crear(Persona persona) {
        
        return personaRepositorio.save(persona);
    }

    @Override
    public Persona actualizar(Persona persona) {
        
        return personaRepositorio.save(persona);
    }

    @Override
    public void eliminar(String id) {
        
        personaRepositorio.deleteById(Long.parseLong(id));
    }

    @Override
    public Persona obtenerPorId(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Persona> obtenerTodo() {
        
        return personaRepositorio.findAll();
    }

    @Override
    public Persona obtenerPorIdentificacion(String identificacion) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Persona obtenerPorEmail(String email) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Persona obtenerPorEdad(Integer edad) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
