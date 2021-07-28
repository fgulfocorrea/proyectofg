package com.fgulfodev.projectnexos.iservicio;

import java.util.Date;
import java.util.List;

import com.fgulfodev.projectnexos.entidades.Mercancia;
import com.fgulfodev.projectnexos.entidades.Usuario;

public interface IMercanciaServicio {
    
    public Mercancia crear(Mercancia mercancia);
    public void eliminar(String id);
    public Mercancia actualizar(Mercancia mercancia);
    public Mercancia obtenerPorId(String id);
    public List<Mercancia> obtenerTodo();
    public Mercancia obtenerPorNombre(String nombre);
    public List<Mercancia> obtenerPorFechaingreso(Date fechaIngreso);
    public List<Mercancia> obtenerPorUsuarioCreacion(Usuario Usuario);

}
