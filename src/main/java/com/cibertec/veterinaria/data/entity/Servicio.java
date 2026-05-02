package com.cibertec.veterinaria.data.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "servicios")
public class Servicio {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_servicio;

	 private String nombre_servicio;
	 private BigDecimal precio;
     private String descripcion;
	 private String icono;
	 
	 public Servicio () {}



	 public Servicio(int id_servicio, String nombre_servicio, BigDecimal precio, String descripcion, String icono) {
		super();
		this.id_servicio = id_servicio;
		this.nombre_servicio = nombre_servicio;
		this.precio = precio;
        this.descripcion = descripcion;
        this.icono = icono;
	 }



	 public int getId_servicio() {
		 return id_servicio;
	 }



	 public void setId_servicio(int id_servicio) {
		 this.id_servicio = id_servicio;
	 }



	 public String getNombre_servicio() {
		 return nombre_servicio;
	 }



	 public void setNombre_servicio(String nombre_servicio) {
		 this.nombre_servicio = nombre_servicio;
	 }



	 public BigDecimal getPrecio() {
		 return precio;
	 }



	 public void setPrecio(BigDecimal precio) {
		 this.precio = precio;
	 }
	 
	 public  String getDescripcion() { return descripcion; }
	 public void setDescripcion(String descripcion) { this.descripcion = descripcion; }



    public  String getIcono() { return icono; }
    public void setIcono(String icono) { this.icono = icono; }
	 
	 
	 
	 

}
