package com.fgulfodev.projectnexos.implementservicio;

import java.util.List;

import com.fgulfodev.projectnexos.entidades.Role;
import com.fgulfodev.projectnexos.iservicio.IRoleServicio;
import com.fgulfodev.projectnexos.repositorio.RolRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolServicio implements IRoleServicio{


    @Autowired
    private RolRepositorio rolRopositorio;

    @Override
    public Role crear(Role role) {

        return rolRopositorio.save(role);
    }

    @Override
    public void eliminar(String id) {
        
        rolRopositorio.deleteById(Long.parseLong(id));
    }

    @Override
    public Role actualizar(Role role) {
        
        return rolRopositorio.save(role);
    }

    @Override
    public Role obtenerPorId(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Role> obtenerTodo() {
        
        return rolRopositorio.findAll();
    }

    @Override
    public Role obtenerPorNombre(String nombre) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
