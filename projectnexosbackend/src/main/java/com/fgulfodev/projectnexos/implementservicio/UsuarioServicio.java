package com.fgulfodev.projectnexos.implementservicio;

import java.util.Date;
import java.util.List;

import com.fgulfodev.projectnexos.entidades.Usuario;
import com.fgulfodev.projectnexos.iservicio.IUsuarioServicio;
import com.fgulfodev.projectnexos.repositorio.UsuarioRepositorio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio implements IUsuarioServicio{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public Usuario crear(Usuario usuario) {
        
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public void eliminar(String id) {
        
        usuarioRepositorio.deleteById(Long.parseLong(id));;
    }

    @Override
    public Usuario actualizar(Usuario usuario) {
        
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public Usuario obtenerPorId(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Usuario> obtenerTodo() {
        
        return usuarioRepositorio.findAll();
    }

    @Override
    public Usuario obtenerPorNombre(String nombre) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Usuario obtenerPorFechaingreso(Date fechaIngreso) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
