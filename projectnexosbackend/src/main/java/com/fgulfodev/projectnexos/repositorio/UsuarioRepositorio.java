package com.fgulfodev.projectnexos.repositorio;

import com.fgulfodev.projectnexos.entidades.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

@Service
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>, JpaSpecificationExecutor<Usuario>  {
    
}
