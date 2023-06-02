package com.ecommercebackend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ecommercebackend.modelo.*;

@Repository
public interface ComponenteRepositorio extends JpaRepository<Componente, Long>{

}
