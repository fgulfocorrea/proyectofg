package com.fgulfodev.projectnexos.iservicio;

import java.util.Date;
import java.util.List;

import com.fgulfodev.projectnexos.entidades.Usuario;

public interface IUsuarioServicio {
    
    public Usuario crear(Usuario usuario);
	public void eliminar(String id);
	public Usuario actualizar(Usuario usuario);
	public Usuario obtenerPorId(String id);
	public List<Usuario> obtenerTodo();
	public Usuario obtenerPorNombre(String nombre);
    public Usuario obtenerPorFechaingreso(Date fechaIngreso);
}
