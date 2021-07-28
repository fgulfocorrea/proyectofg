package com.fgulfodev.projectnexos.implementservicio;

import java.util.Date;
import java.util.List;

import com.fgulfodev.projectnexos.entidades.Mercancia;
import com.fgulfodev.projectnexos.entidades.Usuario;
import com.fgulfodev.projectnexos.iservicio.IMercanciaServicio;
import com.fgulfodev.projectnexos.repositorio.MercanciaRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MercanciaServicio implements IMercanciaServicio{

    @Autowired
    private MercanciaRepositorio mercanciaRepositorio;

    @Override
    public Mercancia crear(Mercancia mercancia) {
        
        return mercanciaRepositorio.save(mercancia);
    }

    @Override
    public void eliminar(String id) {
        mercanciaRepositorio.deleteById(Long.parseLong(id));
        
    }

    @Override
    public Mercancia actualizar(Mercancia mercancia) {
        
        return mercanciaRepositorio.save(mercancia);
    }

    @Override
    public Mercancia obtenerPorId(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Mercancia> obtenerTodo() {
        
        return mercanciaRepositorio.findAll();
    }

    @Override
    public Mercancia obtenerPorNombre(String nombre) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Mercancia> obtenerPorFechaingreso(Date fechaIngreso) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Mercancia> obtenerPorUsuarioCreacion(Usuario Usuario) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
