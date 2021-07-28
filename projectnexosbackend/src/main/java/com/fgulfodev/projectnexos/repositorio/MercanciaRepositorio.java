package com.fgulfodev.projectnexos.repositorio;

import com.fgulfodev.projectnexos.entidades.Mercancia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public interface MercanciaRepositorio extends JpaRepository<Mercancia, Long>, JpaSpecificationExecutor<Mercancia>{
    
	@Query("select a from mercancias a where a.nombreProducto like :nombre")
	List<Mercancia> findByNombreProducto(@Param("nombre")String nombreProducto);
	
	
}
