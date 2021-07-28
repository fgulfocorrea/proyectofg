package com.fgulfodev.projectnexos.repositorio;

import com.fgulfodev.projectnexos.entidades.Persona;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

@Service
public interface PersonaRepositorio extends JpaRepository<Persona, Long>, JpaSpecificationExecutor<Persona>{
    
}
