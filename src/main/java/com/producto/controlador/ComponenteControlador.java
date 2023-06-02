package com.producto.controlador;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.producto.repositorio.ComponenteRepositorio;
import jakarta.annotation.PostConstruct;
import com.producto.excepciones.ResourceNotFoundException;
import com.producto.modelo.Componente;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = {"http://localhost:4200"})

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
	
	@PostMapping("componentes")
	public Componente guardarComponente(@RequestBody Componente componente) {	
		return repositorio.save(componente);
	}
	
	@DeleteMapping("/componentes/{id}")
		public ResponseEntity<?> eliminarComponentePorId(@PathVariable Long id) {
    repositorio.deleteById(id);
    return ResponseEntity.ok().build();
	}


	@PutMapping("/componentes/{id}")

		public ResponseEntity<Componente> actualizarComponente(@PathVariable Long id, @RequestBody Componente detallesComponente) {
		Componente componente = repositorio.findById(id)
						.orElseThrow(() ->  new ResourceNotFoundException("No existe el componente"));

	// Actualizar los campos necesarios del componente existente con los datos del componente actualizado
	componente.setCategoria(detallesComponente.getCategoria());
	componente.setNombre(detallesComponente.getNombre());
	componente.setPrecio(detallesComponente.getPrecio());
	componente.setDescripcion(detallesComponente.getDescripcion());
	componente.setImagen(detallesComponente.getImagen());
	componente.setStock(detallesComponente.getStock());
	componente.setSubcategoria(detallesComponente.getSubcategoria());
	componente.setDestacado(detallesComponente.isDestacado());
	Componente componenteActualizado = repositorio.save(componente);
	return ResponseEntity.ok(componenteActualizado);
}

}

