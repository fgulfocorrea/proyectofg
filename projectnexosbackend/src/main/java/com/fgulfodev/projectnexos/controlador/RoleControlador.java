package com.fgulfodev.projectnexos.controlador;

import java.util.HashMap;
import java.util.Map;

import com.fgulfodev.projectnexos.entidades.Mercancia;
import com.fgulfodev.projectnexos.entidades.Role;
import com.fgulfodev.projectnexos.implementservicio.RolServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RoleControlador.SERVICE_URI)
@CrossOrigin(origins = "*")
public class RoleControlador {
    
    public static final String SERVICE_URI = "/api/role";
    private StringBuilder mensaje;

    @Autowired
    private RolServicio rolServicio;

    @GetMapping(value = "/listar")
    public Map<String, Object> listar() {
        Map<String, Object> datos = new HashMap<>();
        datos.put("listaRoles", rolServicio.obtenerTodo());
        return datos;
    }

    @PostMapping(value = "/guardar")
    public Map<String, Object> guardar(@RequestBody Role role) {
        System.out.println("info:"+role.getNombre());
        Map<String, Object> datos = new HashMap<>();
        rolServicio.crear(role);
        datos.put("msg", "Rol Creado!");
        datos.put("estado", true);
        return datos;
    }

    @PostMapping(value = "/eliminar")
    public Map<String, Object> eliminar(@RequestBody final Role role) {
        
        Map<String, Object> datos = new HashMap<>();
        rolServicio.eliminar(String.valueOf(role.getId()));
        return datos;
    }
}
