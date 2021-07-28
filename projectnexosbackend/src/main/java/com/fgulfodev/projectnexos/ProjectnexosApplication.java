package com.fgulfodev.projectnexos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.fgulfodev.projectnexos.entidades.Persona;
import com.fgulfodev.projectnexos.entidades.Role;
import com.fgulfodev.projectnexos.entidades.Usuario;
import com.fgulfodev.projectnexos.repositorio.PersonaRepositorio;
import com.fgulfodev.projectnexos.repositorio.RolRepositorio;
import com.fgulfodev.projectnexos.repositorio.UsuarioRepositorio;

@CrossOrigin(origins = "*", maxAge = 3600)
@SpringBootApplication
public class ProjectnexosApplication {

	@Autowired
	private RolRepositorio rolRepositorio;

	@Autowired
	private PersonaRepositorio personaRepositorio;

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@PostConstruct
	private void datosIniciales(){

		List<Role> roles = new ArrayList<>();
		Role role = new Role(null, "ASESOR DE VENTAS", "Encargado de las ventas", true);
		roles.add(role);
		role = new Role(null, "ADMINISTRADOR", "Administrador del sistema", true);
		roles.add(role);
		role = new Role(null, "SOPORTE", "Soporte al negocio", true);
		roles.add(role);

		rolRepositorio.saveAll(roles);

		Persona persona = new Persona(null, "1047440562", "Flavio Raul", "Gulfo Correa", 29, "3195801342", "flaviogulfo@gmail.com", true);

		personaRepositorio.save(persona);
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Date parsed = null;
		try {
			parsed = format.parse("2020/09/23");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Usuario usuario = new Usuario(null, "fgulfo", new java.sql.Date(parsed.getTime()), roles.get(1), persona, true);

		usuarioRepositorio.save(usuario);

		Persona persona2 = new Persona(null, "1234567899", "Raul", "Correa", 25, "3195801342", "raul@gmail.com", true);

		personaRepositorio.save(persona2);

		Usuario usuario2 = new Usuario(null, "raul", new java.sql.Date(parsed.getTime()), roles.get(2), persona, true);

		usuarioRepositorio.save(usuario2);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectnexosApplication.class, args);
	}

}
