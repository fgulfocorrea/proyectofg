package com.fgulfodev.projectnexos.iservicio;

import java.util.List;

import com.fgulfodev.projectnexos.entidades.Role;

public interface IRoleServicio {
    
    public Role crear(Role role);
    public void eliminar(String id);
    public Role actualizar(Role role);
    public Role obtenerPorId(String id);
    public List<Role> obtenerTodo();
    public Role obtenerPorNombre(String nombre);
}
