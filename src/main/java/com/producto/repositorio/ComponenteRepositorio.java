package com.producto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.producto.modelo.*;

@Repository
public interface ComponenteRepositorio extends JpaRepository<Componente, Long>{

}
