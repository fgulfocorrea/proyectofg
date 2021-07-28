package com.fgulfodev.projectnexos.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fgulfodev.projectnexos.entidades.Usuario;
import com.fgulfodev.projectnexos.implementservicio.UsuarioServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UsuarioControlador.SERVICE_URI)
@CrossOrigin(origins = "*")
public class UsuarioControlador {
    
    public static final String SERVICE_URI = "/api/usuario";

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping(value = "/listar")
    public Map<String, Object> listar() {
        Map<String, Object> datos = new HashMap<>();
        List<Usuario> listaUsuarios = usuarioServicio.obtenerTodo();
        datos.put("listaUsuarios", listaUsuarios);
        if(listaUsuarios.isEmpty()){
            datos.put("msg","No hay datos!");
        }
        return datos;
    }

    @PostMapping(value = "/guardar")
    public Map<String, Object> guardar(@RequestBody final Usuario usuario) {
        
        Map<String, Object> datos = new HashMap<>();
        usuarioServicio.crear(usuario);
        datos.put("msg", "Usuario Creado!");
        datos.put("estado", true);
        return datos;
    }

    @PostMapping(value = "/eliminar")
    public Map<String, Object> eliminar(@RequestBody final Usuario usuario) {
        
        Map<String, Object> datos = new HashMap<>();
        usuarioServicio.eliminar(String.valueOf(usuario.getId()));
        datos.put("msg", "Usuario Eliminado!");
        return datos;
    }
}
