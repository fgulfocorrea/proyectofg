package com.fgulfodev.projectnexos.repositorio;

import com.fgulfodev.projectnexos.entidades.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

@Service
public interface RolRepositorio extends JpaRepository<Role, Long>, JpaSpecificationExecutor<Role>{
    
}
