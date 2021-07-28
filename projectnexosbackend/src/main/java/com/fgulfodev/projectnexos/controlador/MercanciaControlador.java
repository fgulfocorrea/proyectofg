package com.fgulfodev.projectnexos.controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fgulfodev.projectnexos.entidades.Mercancia;
import com.fgulfodev.projectnexos.entidades.Role;
import com.fgulfodev.projectnexos.implementservicio.MercanciaServicio;
import com.fgulfodev.projectnexos.repositorio.MercanciaRepositorio;
import com.fgulfodev.projectnexos.utilidades.Mensaje;
import com.fgulfodev.projectnexos.utilidades.UtilidadesGenerales;

@RestController
@RequestMapping(MercanciaControlador.SERVICE_URI)
@CrossOrigin(origins = "*")
public class MercanciaControlador {
    public static final String SERVICE_URI = "/api/mercancia";
    private StringBuilder mensaje;

    @Autowired
    private MercanciaServicio mercanciaServicio;
    
    @Autowired
    private MercanciaRepositorio mercanciaRepositorio;

    private UtilidadesGenerales utilidadesGenerales;

    @GetMapping(value = "/listar")
    public Map<String, Object> listar() {
        Map<String, Object> datos = new HashMap<>();
        List<Mercancia> listaMercancia = mercanciaServicio.obtenerTodo();
        datos.put("listaMercancia", listaMercancia);
        if(listaMercancia.isEmpty()){
            datos.put("msg","No hay datos!");
        }
        return datos;
    }

    @PostMapping(value = "/guardar")
    public Map<String, Object> guardarMercancia(@RequestBody Mercancia mercancia) {
        Map<String, Object> datos = new HashMap<>();
        if(verificarDuplicados(mercancia.getNombreProducto())) {
        	datos.put("msg", new Mensaje("Mercancia ya existe!", true, false));
        }else {
        	mercanciaServicio.crear(mercancia); 
        	datos.put("msg", new Mensaje("Mercancia ingresada!", false, true));
        }
        return datos;
    }
    
    @PostMapping(value = "/modificar")
    public Map<String, Object> modificarMercancia(@RequestBody Mercancia mercancia) {
        Map<String, Object> datos = new HashMap<>();
    	mercanciaServicio.crear(mercancia); 
    	datos.put("msg", new Mensaje("Mercancia Modificada!", false, true));
        return datos;
    }
    
    @PostMapping(value = "/filtrar/{nombre}")
    public Map<String, Object> filtrar(@PathVariable String nombre) {
        List<Mercancia> listaBusqueda = new ArrayList<>();
        Map<String, Object> datos = new HashMap<>();
        listaBusqueda = mercanciaRepositorio.findByNombreProducto(nombre);
        if(listaBusqueda.isEmpty()) {
        	datos.put("msg", new Mensaje("No hay datos!", true, false));
        }else {
        	datos.put("listaMercancia", listaBusqueda);
        }
        return datos;
    }
    
    @PostMapping(value = "/eliminar/{id}")
    public Map<String, Object> eliminar(@PathVariable Integer id) {
        
        Map<String, Object> datos = new HashMap<>();
        mercanciaServicio.eliminar(String.valueOf(id));
        datos.put("msg", new Mensaje("Mercancia eliminada!", false, true));
        return datos;
    }
    
    public Boolean verificarDuplicados(String nombreProducto) {
    	List<Mercancia> listaMercancia = new ArrayList<Mercancia>();
    	listaMercancia = mercanciaRepositorio.findByNombreProducto(nombreProducto);
    	System.out.println("size:"+listaMercancia.size());
    	return !listaMercancia.isEmpty() ? true : false;
    }
}
