package com.producto.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.producto.repositorio.ComponenteRepositorio;
import com.producto.modelo.Componente;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200/")
public class ComponenteControlador {
	@Autowired
	private ComponenteRepositorio repositorio;
	
	//este metodo retorna todos los componentes
	@GetMapping("/componentes")
	public List<Componente> listarTodosLosComponente(){
		return repositorio.findAll();
	}
	
	//este metodo retorna un componente por ID
	@GetMapping("componentes/{id}")
	public ResponseEntity<Optional<Componente>> obtenerComponentePorId(@PathVariable Long id) {
		Optional<Componente> componente = repositorio.findById(id);
		return ResponseEntity.ok(componente);
	}
	
}

