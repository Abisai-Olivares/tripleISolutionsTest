package trimple.soluciones.tripleitecnico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import trimple.soluciones.tripleitecnico.model.Pelicula;
import trimple.soluciones.tripleitecnico.repository.RepositoryPelicula;

@Service
public class ServicePeliculaImplements implements ServicePelicula {
	
	
	
	@Autowired
	private RepositoryPelicula repositoryPelicula;
	
	@Override
	public List<Pelicula> listarPeliculas(){
		return repositoryPelicula.findAll();
	}
	@Override
	public Pelicula detallesPelicula (long id) {
		Optional<Pelicula> peli= repositoryPelicula.findById(id);
		if(peli.isPresent()) {
			return peli.get();
		}
		return null;
	}
	
	@Override
	public Pelicula crearPelicula(Pelicula pelicula) {
		
		return	repositoryPelicula.save(pelicula);

	}


	@Override
	public boolean eliminar(long id) {
		boolean existe = repositoryPelicula.existsById(id);
		if(existe) {
			repositoryPelicula.deleteById(id);
			return repositoryPelicula.existsById(id);
		}
		return false;
	}
	

}
