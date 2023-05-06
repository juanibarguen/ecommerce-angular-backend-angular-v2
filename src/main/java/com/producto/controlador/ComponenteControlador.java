package com.producto.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping("/componentes")
	public List<Componente> listarTodosLosComponente(){
		return repositorio.findAll();
	}
	
	@GetMapping("/componentes/{id}")
	public Optional<Componente> listarPorId(Long id){
		System.out.println("asd"+id);
		return repositorio.findById(id);
	}
	
	
	
	
}
