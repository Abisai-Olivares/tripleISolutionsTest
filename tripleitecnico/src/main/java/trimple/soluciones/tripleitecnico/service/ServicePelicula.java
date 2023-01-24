package trimple.soluciones.tripleitecnico.service;

import java.util.List;

import trimple.soluciones.tripleitecnico.model.Pelicula;

public interface ServicePelicula {
	 Pelicula detallesPelicula (long id); 
	List<Pelicula>listarPeliculas();
	Pelicula crearPelicula(Pelicula pelicula);
	 boolean eliminar(long id) ;

}
