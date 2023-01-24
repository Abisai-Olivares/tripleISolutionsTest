package trimple.soluciones.tripleitecnico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import trimple.soluciones.tripleitecnico.model.Pelicula;
import trimple.soluciones.tripleitecnico.service.ServicePeliculaImplements;

@Controller
public class PeliculaController {
	@Autowired
	private ServicePeliculaImplements servicePeliculaImplements;

	@GetMapping("/peliculas")
	public String listPeliculas(Model model) {
		List<Pelicula> listaPeliculas = servicePeliculaImplements.listarPeliculas();
		model.addAttribute("listaPeliculas", listaPeliculas);
		return "peliculas";
	}

	@PostMapping("/crearPelicula")
	public ResponseEntity<Pelicula> crearPelicula(@Validated @RequestBody Pelicula pelicula) {
		Pelicula peli = servicePeliculaImplements.crearPelicula(pelicula);
		return new ResponseEntity(peli, HttpStatus.CREATED);
	}
	
	@PostMapping("/guardar")
	public String guardar(Pelicula pelicula) {
	servicePeliculaImplements.crearPelicula(pelicula);
		return "redirect:/peliculas";

	}	
	@GetMapping("/detalle/{id}")
	public String detallePelicula(@PathVariable long id,Model model) {
		Pelicula pelicula=servicePeliculaImplements.detallesPelicula(id);
		model.addAttribute("pelicula", pelicula);
		
		return"detallesPelicula";
	}
	
	
	@GetMapping("/actualizar/{id}")
	public String actualizarPelicula(@PathVariable long id,Model model) {
		Pelicula pelicula=servicePeliculaImplements.detallesPelicula(id);
		model.addAttribute("pelicula", pelicula);
		
		return"editform";
	}
	

	@GetMapping("/peliculas/{id}")
	public String eliminar(@PathVariable int id, Model model) {
		servicePeliculaImplements.eliminar(id);
		return "redirect:/peliculas";
	}

}
