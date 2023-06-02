package com.ecommercebackend.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "componentes")

public class Componente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "categoria")
	private String categoria;

	@Column(name = "nombre", length = 150, nullable = false)
	private String nombre;

	@Column(name = "descripcion", length = 300, nullable = false)
	private String descripcion;

	@Column(name = "imagen", length = 200, nullable = false)
	private String imagen;

	@Column(name = "subcategoria")
	private String subcategoria;

	@Column(name = "stock")
	private double stock;

	@Column(name = "precio")
	private double precio;

	@Column(name = "destacado")
	private boolean destacado;

	public Componente() {

	}

	public Componente(long id, String categoria, String nombre, String descripcion, String imagen, double precio,
			boolean destacado, String subcategoria, double stock) {
		super();
		this.subcategoria = subcategoria;
		this.stock = stock;
		this.id = id;
		this.categoria = categoria;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.precio = precio;
		this.destacado = destacado;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean isDestacado() {
		return destacado;
	}

	public void setDestacado(boolean destacado) {
		this.destacado = destacado;
	}

	public void setStock(double stock) {
		this.stock = stock;
	}


	public double getStock() {
		return stock;
	}

	public String getSubcategoria() {
		return subcategoria;
	}

	public void setSubcategoria(String subcategoria) {
		this.subcategoria = subcategoria;
	}

}
