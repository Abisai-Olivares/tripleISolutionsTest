package trimple.soluciones.tripleitecnico.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="peliculas")
public class Pelicula {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@Column
private String titulo;
@Column
private int anio;
@Column
private String genero;
@Column
private String actores;
@Column
private double duracion;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitulo() {
	return titulo;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
}
public int getAnio() {
	return anio;
}
public void setAnio(int anio) {
	this.anio = anio;
}
public String getGenero() {
	return genero;
}
public void setGenero(String genero) {
	this.genero = genero;
}
public String getActores() {
	return actores;
}
public void setActores(String actores) {
	this.actores = actores;
}
public double getDuracion() {
	return duracion;
}
public void setDuracion(double duracion) {
	this.duracion = duracion;
}



	
	

}
